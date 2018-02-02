package testWebProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentDB
{

	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	private Connection c = null;

	public void connect(String url, String user, String password)
	{
		try
		{
			Class.forName(DRIVER_CLASS_NAME);
			c = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void postComment(Comment c)
	{
		Statement s = null;

		try
		{
			s = this.c.createStatement();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
