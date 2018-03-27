package Final.Product.Part;

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

public class PartHandler
{
    public static boolean isPart(String s)
    {
        return s.equalsIgnoreCase("part");
    }

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public PartHandler()
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
     * Code to save a {@link Part}.
     */
    public int create(Part p)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer partid = null;

        try
        {
            t = s.beginTransaction();
            partid = (Integer) s.save(p);
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

        System.out.println("part id of created part:");
        System.out.println(partid);
        return partid;

    }
        
    // code to get a Part
    public Part read(int pid)
    {
        Session s = sessionFactory.openSession();

        Part p = s.get(Part.class, pid);

        s.close();

        return p;
    }

    /***
     * Return ALL Parts.
     */
    @SuppressWarnings("unchecked")
    public List<Part> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<Part> l = (ArrayList<Part>) s.createCriteria(Part.class).list();

        s.close();
        return l;
    }

    // code to remove a Part
    public void delete(int partid)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            Part p = (Part) s.get(Part.class, partid);
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
        System.out.println(PartHandler.class.getName() + " main().");

        PartHandler manager = new PartHandler();

        manager.setup();

        ArrayList<Part> Parts = (ArrayList<Part>) manager.readAll();

        System.out.println("all parts:");

        for(Part p : Parts)
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
