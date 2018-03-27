package Final.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Final.Customer.Customer;
import Final.Product.Car.Car;
import Final.Product.Part.Part;
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
    @ManyToOne
    @JoinColumn(name = "ptid")
    private ProductType ptype;

    /***
     * The Customer who owns this Product.
     */
    @ManyToOne
    @JoinColumn(name = "ownercid")
    private Customer owner;

    /***
     * The Car associated with this Product, if it exists.
     */
    @OneToOne
    @JoinColumn(name = "carid")
    private Car car;

    /***
     * The Part associated with this Product, if it exists.
     */
    @OneToOne
    @JoinColumn(name = "partid")
    private Part part;

    /***
     * The name of this Product.
     */
    @Column(name = "name")
    private String name;

    public Product(ProductType ptype, Customer owner, Car car, Part part, String name)
    {
        this.ptype = ptype;
        this.owner = owner;
        this.car = car;
        this.part = part;
        this.name = name;
    }

    private Integer getPid()
    {
        return pid;
    }

    private void setPid(int pid)
    {
        this.pid = pid;
    }

    private String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    private ProductType getPtype()
    {
        return ptype;
    }

    private void setPtype(ProductType ptype)
    {
        this.ptype = ptype;
    }

    private Customer getOwner()
    {
        return owner;
    }

    private void setOwner(Customer owner)
    {
        this.owner = owner;
    }

    private Car getCar()
    {
        return car;
    }

    private void setCar(Car car)
    {
        this.car = car;
    }

    private Part getPart()
    {
        return part;
    }

    private void setPart(Part part)
    {
        this.part = part;
    }

    /***
     * @return This Product's Car/Part's Class.
     */
    public Class getObjectClass()
    {
        return this.getObject().getClass();
    }

    /***
     * @return The Car or Part associated with this Product.
     */
    public Object getObject()
    {
        if(this.getCar() != null)
        {
            return this.getCar();
        }
        if(this.getPart() != null)
        {
            return this.getPart();
        }

        return null;
    }

    @Override
    public String toString()
    {
        String ret = "";

        Object o = this.getObject(); // Product's car OR part

        String objstr = o.toString(); // car/part toString
        String ownername = this.getOwner().getName();
        String type = this.getPtype().toString();

        ret += String.format("[%d] Product<%s> owned by '%s': '%s'", this.getPid(), type, ownername, objstr);

        return ret;
    }
}
