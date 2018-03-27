package Final.Product;

import java.util.ArrayList;
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
        System.out.println("READ?!??!");
        Session s = sessionFactory.openSession();

        System.out.printf("ProductHandler reading by customer '%s' w/ id '%d'.", c.getName(), c.getCid());

        int cid = c.getCid(); // customer's id

        ArrayList<Product> products = (ArrayList<Product>) s.createCriteria(Product.class)
                .add(Restrictions.eq("owner", c)).list();

        System.out.println("Results:");
        for(Product p : products)
        {
            System.out.println(p.toString());
        }

        s.close();

        return products;
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
