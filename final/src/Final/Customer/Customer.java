package Final.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * A single Customer.
 */

@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @Column(name = "cid")
    private int cid;

    private String username;
    private String email;
    private String passhash;

    public Customer(String username, String email, String passhash)
    {
        this.username = username;
        this.email = email;
        this.passhash = passhash;
    }
    
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

    public String getPassHash()
    {
        return passhash;
    }

    public void setPassHash(String passhash)
    {
        this.passhash = passhash;
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
