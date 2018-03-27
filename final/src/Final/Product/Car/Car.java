package Final.Product.Car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Product.GenericProduct;

@Entity
@Table(name = "Car")
public class Car implements GenericProduct
{
    @Id
    @Column(name = "carid")
    private int cid;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "miles")
    private int miles;

    @Column(name = "year")
    private int year;
    
    public Car()
    {
        
    }
    
    public Car(String make, String model, int miles, int year)
    {
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.year = year;
    }
    
    public Integer getId()
    {
        return this.getCid();
    }

    private Integer getCid()
    {
        return this.cid;
    }

    private void setCid(int cid)
    {
        this.cid = cid;
    }

    private String getMake()
    {
        return make;
    }

    private void setMake(String make)
    {
        this.make = make;
    }

    private String getModel()
    {
        return model;
    }

    private void setModel(String model)
    {
        this.model = model;
    }

    private long getMiles()
    {
        return miles;
    }

    private void setMiles(int miles)
    {
        this.miles = miles;
    }

    private int getYear()
    {
        return year;
    }

    private void setYear(int year)
    {
        this.year = year;
    }

}
