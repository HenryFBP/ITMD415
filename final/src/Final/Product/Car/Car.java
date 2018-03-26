package Final.Product.Car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car
{
    @Id
    @Column(name = "cid")
    private int cid;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "miles")
    private long miles;

    @Column(name = "year")
    private int year;

    private Integer getCid()
    {
        return cid;
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

    private void setMiles(long miles)
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
