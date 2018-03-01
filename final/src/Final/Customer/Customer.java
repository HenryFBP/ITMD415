package Final.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;

	private String username;
	private String email;
	private Byte[] passwordHash;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "cid")
	public Integer getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getName()
	{
		return username;
	}

	public void setName(String name)
	{
		this.username = name;
	}

	public String toString()
	{
		return null;
	}

	public Byte[] getPasswordHash()
	{
		return passwordHash;
	}

	public void setPasswordHash(Byte[] passwordHash)
	{
		this.passwordHash = passwordHash;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
