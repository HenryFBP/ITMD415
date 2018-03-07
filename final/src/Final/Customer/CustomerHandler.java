package Final.Customer;

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

import com.amdelamar.jhash.exception.InvalidHashException;

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
        catch (Exception e)
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
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (t != null)
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
     * Get a customer by Username.
     * 
     * @param username
     *            The username of the Customer
     */
    public Customer read(String username)
    {
        Session s = sessionFactory.openSession();

        Query q = s.createQuery("from Customer where username = :un");

        q.setString("un", username);

        Customer c = (Customer) q.uniqueResult();

        return c;
    }

    /***
     * Given a Customer's username, tells you if that Customer already exists.
     * 
     * @param username
     *            The Customer's username.
     * @return If a Customer with this username exists.
     */
    public Boolean exists(String username)
    {
        Customer c = read(username);

        return (c != null);
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
        catch (HibernateException e)
        {
            if (t != null)
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

    /***
     * Delete a Customer by username.
     * 
     * @param username
     *            The username of the Customer to be deleted.
     * 
     * @return The customer that was deleted.
     */
    public Customer delete(String username)
    {
        Customer c = read(username);

        int cid = c.getCid();

        delete(cid);

        return c;
    }

    // code to run the program
    public static void main(String[] args) throws InvalidHashException
    {
        System.out.println(CustomerHandler.class.getName() + " main().");

        CustomerHandler manager = new CustomerHandler();

        manager.setup();

        String username = "HenryFBP";
        String email = "HenryFBP@gmail.com";
        String password = "mycoolpassword"; // SECURITY TO THE MAXXXXXX!!!!!!

        Customer testCustomer = new Customer(username, email, password); // test person

        String tch = testCustomer.getPassHash(); // test customer's hash

        if (Lib.verifyHash("mycoolpassword", tch))
        {
            System.out.println("Password is correct! :)");
        }
        else
        {
            System.out.println("Something's wrong, since we hashed '" + password
                    + "' but it doesn't seem to be able to be verified as the thing that made the hash.");

        }

        Customer c = manager.read(username); // attempt to read user

        if (c == null) // does person with test username exist already
        {
            System.out.println("User '" + username + "' does not exist. Let's create them!");
            manager.create(testCustomer); // save test person
        }
        else
        {
            System.out.println("Won't create user '" + username + "' as it looks like it already exists:");
            System.out.println(c);

            System.out.println("For testing purposes, let's delete this person!");
            manager.delete(username);
        }

        try
        {
            manager.stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
