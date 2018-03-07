package Final.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Customer.Customer;
import Final.ProductType.ProductType;

@Entity
@Table(name = "product")
public class Product
{
    @Id
    @Column(name = "pid")
    private int pid;

    /***
     * The ProductType of this Product.
     */
    private ProductType ptype;

    /***
     * The Customer who owns this Product.
     */
    private Customer owner;

    /***
     * The name of this Product.
     */
    private String name;

    /***
     * How much this Product costs.
     */
    private Double price;

    public Integer getPid()
    {
        return pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
