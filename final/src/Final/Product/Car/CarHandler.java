package Final.Product.Car;

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

public class CarHandler
{
    public static boolean isCar(String s)
    {
        return s.equalsIgnoreCase("car");
    }
    
    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    public CarHandler()
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
     * Code to save a {@link Car}.
     */
    public int create(Car p)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;
        Integer Carid = null;

        try
        {
            t = s.beginTransaction();
            Carid = (Integer) s.save(p);
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

        System.out.println("Car id of created Car:");
        System.out.println(Carid);
        return Carid;

    }
        
    // code to get a Car
    public Car read(int pid)
    {
        Session s = sessionFactory.openSession();

        Car p = s.get(Car.class, pid);

        s.close();

        return p;
    }

    /***
     * Return ALL Cars.
     */
    @SuppressWarnings("unchecked")
    public List<Car> readAll()
    {
        Session s = sessionFactory.openSession();

        ArrayList<Car> l = (ArrayList<Car>) s.createCriteria(Car.class).list();

        s.close();
        return l;
    }

    // code to remove a Car
    public void delete(int Carid)
    {
        Session s = sessionFactory.openSession();
        Transaction t = null;

        try // attempt to delete
        {
            t = s.beginTransaction();

            Car p = (Car) s.get(Car.class, Carid);
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
        System.out.println(CarHandler.class.getName() + " main().");

        CarHandler manager = new CarHandler();

        manager.setup();

        ArrayList<Car> Cars = (ArrayList<Car>) manager.readAll();

        System.out.println("all Cars:");

        for(Car p : Cars)
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
