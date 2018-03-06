package Final.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/***
 * A single Customer.
 */

//@formatter:off
@Entity
@Table(
	name = "customer",
	uniqueConstraints=
		@UniqueConstraint(
			columnNames={"username","email"})
)
//@formatter:on

public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int cid;

    private String username;
    private String email;
    private String passwordhash;

    public Customer(String username, String email, String passwordhash)
    {
        this.username = username;
        this.email = email;
        this.passwordhash = passwordhash;
    }

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

    public String getPasswordHash()
    {
        return passwordhash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordhash = passwordHash;
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
