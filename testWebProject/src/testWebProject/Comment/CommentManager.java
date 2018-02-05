package testWebProject.Comment;

import java.sql.Date;
import java.time.Instant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CommentManager
{
	protected SessionFactory sessionFactory = null;
	private static long DEFAULT_ID = 20;

	/***
	 * Load Hibernate Session factory.
	 */
	protected void setup()
	{
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try
		{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception ex)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	// code to close Hibernate Session factory
	protected void exit()
	{
	}

	/***
	 * code to save a {@link Comment}
	 */
	protected void create()
	{
		Comment comment = new Comment();
		comment.setName("Anony Moose");
		comment.setDate(new Date(Instant.now().getEpochSecond()));
		comment.setContent("hi there");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(comment);

		session.getTransaction().commit();
		session.close();
	}

	// code to get a comment
	protected void read()
	{
		Session session = sessionFactory.openSession();

		long bookId = DEFAULT_ID;
		Comment comment = session.get(Comment.class, bookId);

		System.out.printf("Name:    '%s'\n", comment.getName());
		System.out.printf("Date:    '%s'\n", comment.getDate());
		System.out.printf("Content: '%s'\n", comment.getContent());

		session.close();
	}

	// code to modify a comment
	protected void update()
	{
		Comment comment = new Comment();
		comment.setName("updated name");
		comment.setDate(new Date(Instant.now().getEpochSecond()));
		comment.setContent("updated content");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(comment);

		session.getTransaction().commit();
		session.close();
	}

	// code to remove a comment
	protected void delete()
	{
		Comment comment = new Comment();
		comment.setCid(DEFAULT_ID);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(comment);

		session.getTransaction().commit();
		session.close();
	}

	// code to run the program
	public static void main(String[] args)
	{
		CommentManager manager = new CommentManager();
		manager.setup();

		manager.create();

		manager.exit();
	}
}
