package Final.Customer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import Final.Lib;

public class CustomerHandler
{
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public CustomerHandler()
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
     * Code to save a {@link Customer}.
     */
    public int create(Customer c)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer cID = null;

        try
        {
            t = s.beginTransaction();
            cID = (Integer) s.save(c);
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

        return cID;

    }

    // code to get a customer
    public Customer read(int cID)
    {
        Session s = sessionFactory.openSession();

        Customer c = s.get(Customer.class, cID);

        s.close();

        return c;
    }

    /***
     * Return ALL customers.
     */
    @SuppressWarnings("unchecked")
    public List<Customer> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<Customer> l = (ArrayList<Customer>) s.createCriteria(Customer.class).list();

        s.close();
        return l;
    }

    // code to remove a customer
    public void delete(int cID)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            Customer c = (Customer) s.get(Customer.class, cID);
            s.delete(c);
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
        System.out.println(CustomerHandler.class.getName() + " main().");

        CustomerHandler manager = new CustomerHandler();

        manager.setup();
        
        Customer testCustomer = new Customer("HenryFBP", "HenryFBP@gmail.com", Lib.hash("password"));

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
