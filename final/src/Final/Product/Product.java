package Final.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "carid", nullable = true)
    private Car car;

    /***
     * The Part associated with this Product, if it exists.
     */
    @OneToOne
    @JoinColumn(name = "partid", nullable = true)
    private Part part;

    /***
     * The name of this Product.
     */
    @Column(name = "name")
    private String name;

    public Product()
    {

    }

    public Product(ProductType ptype, Customer owner, Car car, Part part, String name)
    {
        this.ptype = ptype;
        this.owner = owner;
        this.car = car;
        this.part = part;
        this.name = name;
    }

    protected Integer getPid()
    {
        return pid;
    }

    protected void setPid(int pid)
    {
        this.pid = pid;
    }

    protected String getName()
    {
        return name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    protected ProductType getPtype()
    {
        return ptype;
    }

    protected void setPtype(ProductType ptype)
    {
        this.ptype = ptype;
    }

    protected Customer getOwner()
    {
        return owner;
    }

    protected void setOwner(Customer owner)
    {
        this.owner = owner;
    }

    protected Car getCar()
    {
        return car;
    }

    protected void setCar(Car car)
    {
        this.car = car;
    }

    protected Part getPart()
    {
        return part;
    }

    protected void setPart(Part part)
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
    public GenericProduct getObject()
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

        GenericProduct o = this.getObject(); // Product's car OR part

        String objstr = o.toString(); // car/part toString
        int objid = o.getId(); // car/part id
        String ownername = this.getOwner().getName();
        String type = this.getPtype().toString();

        ret += String.format("[%d] Product<%s[%d]> owned by '%s': '%s'", this.getPid(), type, objid, ownername, objstr);

        return ret;
    }
}
