package testWebProject.Comment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CommentManager
{
	protected SessionFactory sessionFactory = null;

	/***
	 * Load Hibernate Session factory.
	 */
	public void setup()
	{
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try
		{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Exception ex)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	// code to close Hibernate Session factory
	public void exit()
	{
		if(sessionFactory != null)
		{
			sessionFactory.getCurrentSession().close();
			sessionFactory.close();
		}

	}

	/***
	 * Code to save a {@link Comment}.
	 */
	public Long create(Comment c)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;
		Long cID = null;

		try
		{
			t = s.beginTransaction();
			cID = (Long) s.save(c);
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

	// code to get a comment
	public Comment read(long cID)
	{
		Session s = sessionFactory.openSession();

		Comment c = s.get(Comment.class, cID);

		s.close();

		return c;
	}

	// code to get all comments
	@SuppressWarnings("unchecked")
	public List<Comment> readAll()
	{
		Session s = sessionFactory.openSession();

		ArrayList<Comment> l = (ArrayList<Comment>) s.createCriteria(Comment.class).list();

		s.close();
		return l;
	}

	// code to modify a comment
	public void update(Long cID, Comment updatedComment)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try
		{
			t = s.beginTransaction();
			Comment c = (Comment) s.get(Comment.class, cID);

			c.deepCopy(updatedComment); // copy all things
			c.setCid(cID); // but retain the cID

			s.update(c);
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

	// code to remove a comment
	public void delete(Long cID)
	{
		Session s = sessionFactory.openSession();
		Transaction t = null;

		try // attempt to delete
		{
			t = s.beginTransaction();

			Comment c = (Comment) s.get(Comment.class, cID);
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
		CommentManager manager = new CommentManager();
		manager.setup();

		manager.create(new Comment());

		manager.exit();
	}
}
