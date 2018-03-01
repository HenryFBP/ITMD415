import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public static void main(String[] args) 
	{
		
	}
	
	public void connectToSQL() throws Exception
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/ITMD415?user=root&password=");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void createTables() throws Exception
	{
		try{
			statement = connect.createStatement();
			statement.executeQuery("CREATE TABLE Users ("
					+ "UserID int NOT NULL AUTO_INCREMENT,"
					+ "UserName varchar(30) NOT NULL,"
					+ "UserPassword varchar(30) NOT NULL,"
					+ "UserDoB varchar(30) NOT NULL,"
					+ "PRIMARY KEY (UserID)"
					+ ");");
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void close()
	{
		try {
			if(connect != null)
			{
				connect.close();
			}
			if(statement != null)
			{
				statement.close();
			}
			if(resultSet != null)
			{
				resultSet.close();
			}
		} catch (Exception e) {
			System.out.println("Error: Error closing out of object.");
		}
	}

}
