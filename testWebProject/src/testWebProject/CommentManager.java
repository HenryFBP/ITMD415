package testWebProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CommentManager
{
	protected SessionFactory sessionfactory = null;

	/***
	 * Load Hibernate Session factory.
	 */
	protected void setup()
	{
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try
		{
			sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Exception ex)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	// code to close Hibernate Session factory
	protected void exit()
	{
	}

	/***
	 *  code to save a {@link Comment}
	 */
	protected void create()
	{
	}

	// code to get a book
	protected void read()
	{
	}

	// code to modify a book
	protected void update()
	{
	}

	// code to remove a book
	protected void delete()
	{
	}

	// code to run the program
	public static void main(String[] args)
	{
	}
}
