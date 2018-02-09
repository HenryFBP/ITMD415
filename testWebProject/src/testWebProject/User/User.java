package testWebProject.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable
{
	private static final long serialVersionUID = 1635601937986452018L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;

	private String name;	
	private String email;
	private String password;
	private long dob;

	protected User(int uid, String n, String e, long d)
	{
		this.uid = uid;
		this.name = n;
		this.email = e;
		this.dob = d;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "user_id")
	protected int getUid()
	{
		return uid;
	}

	protected void setUid(int p)
	{
		this.uid = p;
	}

	protected String getName()
	{
		return name;
	}

	protected void setName(String n)
	{
		this.name = n;
	}
	
	protected String getEmail()
	{
		return email;
	}
	
	protected void setEmail(String e)
	{
		this.email = e;
	}
	

	protected String getPassword()
	{
		return password;
	}

	protected void setPassword(String p)
	{
		this.password = p;
	}

	protected long getDob()
	{
		return dob;
	}

	protected void setDob(long dob)
	{
		this.dob = dob;
	}

	@Override
	public String toString()
	{
		String ret = "";

		ret += String.format("ID %d: %s <%s> '%s'",this.getUid(),this.getName(),this.getEmail());

		return ret;
	}

}
