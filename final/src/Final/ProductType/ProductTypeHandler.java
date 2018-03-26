package Final.ProductType;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class ProductTypeHandler
{
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public ProductTypeHandler()
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
     * Code to save a {@link ProductType}.
     */
    public int create(ProductType pt)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer ptid = null;

        try
        {
            t = s.beginTransaction();
            ptid = (Integer) s.save(pt);
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

        return ptid;

    }

    // code to get a ProductType
    public ProductType read(int ptid)
    {
        Session s = sessionFactory.openSession();

        ProductType pt = s.get(ProductType.class, ptid);

        s.close();

        return pt;
    }

    /***
     * @return A ProductType by name.
     */
    public ProductType read(String ptname)
    {
        Session s = sessionFactory.openSession();

        Query q = s.createQuery("from ProductType where name = :n");

        q.setString("n", ptname);

        ProductType pt = (ProductType) q.uniqueResult();

        return pt;

    }

    /***
     * Return ALL ProductTypes.
     */
    @SuppressWarnings("unchecked")
    public List<ProductType> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<ProductType> l = (ArrayList<ProductType>) s.createCriteria(ProductType.class).list();

        s.close();
        return l;
    }

    // code to remove a ProductType
    public void delete(int ptid)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            ProductType pt = (ProductType) s.get(ProductType.class, ptid);
            s.delete(pt);
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
        System.out.println(ProductTypeHandler.class.getName() + " main().");

        ProductTypeHandler manager = new ProductTypeHandler();

        manager.setup();

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
