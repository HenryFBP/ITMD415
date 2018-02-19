package lab2;

public class Customer
{
	private String name;
	private String SSN;
	private String zip;
	private String email;
	private String street;
	private String city;
	private String state;

	public Customer(String name, String ssn, String zip, String email, String street, String city, String state)
	{
		this.name = name;
		this.SSN = ssn;
		this.zip = zip;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSSN()
	{
		return SSN;
	}

	public void setSSN(String sSN)
	{
		SSN = sSN;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}
}
