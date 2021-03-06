package Final.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.jsoup.nodes.Element;

import Final.Lib;
import Final.Customer.Customer;

public class ProductHandler
{
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public ProductHandler()
    {
        this.setup();
    }

    /***
     * Load Hibernate Session factory.
     */
    public void setup()
    {
        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        try
        {
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    // code to close Hibernate Session factory
    public void stop() throws Exception
    {
        sessionFactory.close();
    }

    /***
     * Code to save a {@link Product}.
     */
    public int create(Product pt)
    {
        System.out.println("Product create begin");
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer pid = null;

        try
        {
            t = s.beginTransaction();
            pid = (Integer) s.save(pt);
            t.commit();
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            if(t != null)
            {
                t.rollback();
            }
        }
        finally
        {
            s.close();
        }

        return pid;

    }

    /***
     * Given a Customer, return all Products that they own.
     */
    public ArrayList<Product> read(Customer c)
    {
        Session s = sessionFactory.openSession();

        int cid = c.getCid(); // customer's id

        ArrayList<Product> products = (ArrayList<Product>) s.createCriteria(Product.class)
                .add(Restrictions.eq("owner", c)).list();

        s.close();

        return products;
    }

    /***
     * Sort a list of products into a class-denoted Map object.
     */
    public static HashMap<Class, ArrayList<Product>> sortProductsByClass(ArrayList<Product> products)
    {
        HashMap<Class, ArrayList<Product>> ret = new HashMap<Class, ArrayList<Product>>();

        for(Product p : products)
        {
            Class c = p.getObjectClass(); // product class <TYPE>

            if(!ret.containsKey(c)) // if it doesn't exist
            {
                ret.put(c, new ArrayList<Product>()); // make blank list
            }

            ArrayList<Product> ps = ret.get(c); // list of product of type <TYPE>

            ps.add(p); // add product to that list

            ret.put(p.getObjectClass(), ps); // save it
        }

        return ret;
    }

    /***
     * Turn a HashMap of Class->ArrayList&lt;Product> into an HTML element.
     * 
     * @param productsMap
     * @return
     */
    public static String ProductHashMapToHTML(HashMap<Class, ArrayList<Product>> productsMap)
    { //TODO this generates invalid html. FIXME please.
        Element root = new Element("ul");

        for(Class c : productsMap.keySet()) // for each type of product
        {
            ArrayList<Product> products = productsMap.get(c); // get list of products of type <p>

            Element productTypeHeader = new Element("h2"); // blank header

            productTypeHeader.append(c.getSimpleName()); // add type to header
            
            Element productListUL = new Element("ul");//empty list of product<TYPE>

            productListUL.appendChild(productTypeHeader); // add h2 to ul

            for(Product p : products)
            {
                Element productElt = new Element("li");

                Element productDesc = new Element("p");
                productDesc.append(Lib.websafe(p.toString()));

                productElt.insertChildren(0, productDesc); // add desc to inner li

                System.out.println("A product elt:");
                System.out.println(productElt.toString());
                
                productListUL.appendChild(productElt); // add li to ul
            }

            root.appendChild(productListUL); // add list of products

        }

        String r = root.toString();

        System.out.println();
        System.out.println(r);

        return r;
    }

    // code to get a Product
    public Product read(int pid)
    {
        Session s = sessionFactory.openSession();

        Product p = s.get(Product.class, pid);

        s.close();

        return p;
    }

    /***
     * Return ALL Products.
     */
    @SuppressWarnings("unchecked")
    public List<Product> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<Product> l = (ArrayList<Product>) s.createCriteria(Product.class).list();

        s.close();
        return l;
    }

    // code to remove a Product
    public void delete(int pid)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            Product p = (Product) s.get(Product.class, pid);
            s.delete(p);
            t.commit();
        }
        catch(HibernateException e)
        {
            if(t != null)
            {
                t.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }
    }

    // code to run the program
    public static void main(String[] args)
    {
        System.out.println(ProductHandler.class.getName() + " main().");

        ProductHandler manager = new ProductHandler();

        manager.setup();

        ArrayList<Product> products = (ArrayList<Product>) manager.readAll();

        System.out.println("all products:");

        for(Product p : products)
        {
            System.out.println(p.toString());
        }

        try
        {
            manager.stop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
