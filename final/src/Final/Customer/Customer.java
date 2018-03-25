package Final.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Lib;

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
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "email")
    private String email;

    @Column(name = "passhash")
    private String passhash;

    public Customer()
    {

    }

    public Customer(int cid, String username, String email, String password)
    {
        this.cid = cid;
        this.username = username;
        this.email = email;
        this.passhash = Lib.hash(password);
    }

    public Customer(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.passhash = Lib.hash(password);
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

    public String toString()
    {
        return String.format("[%03d]: (%20s)<%30s>: [%80s]", this.cid, this.username, this.email, this.passhash);
    }

}
