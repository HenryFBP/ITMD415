package Final.Product.Car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Product.GenericProduct;

@Entity
@Table(name = "Car")
public class Car implements GenericProduct
{
    @Id
    @Column(name = "carid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int carid;

    @Column(name = "make")
    protected String make;

    @Column(name = "model")
    protected String model;

    @Column(name = "miles")
    protected int miles;

    @Column(name = "year")
    protected int year;

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
        return this.getCarId();
    }

    protected Integer getCarId()
    {
        return this.carid;
    }

    protected void setCarId(int carId)
    {
        this.carid = carId;
    }

    protected String getMake()
    {
        return make;
    }

    protected void setMake(String make)
    {
        this.make = make;
    }

    protected String getModel()
    {
        return model;
    }

    protected void setModel(String model)
    {
        this.model = model;
    }

    protected int getMiles()
    {
        return miles;
    }

    protected void setMiles(int miles)
    {
        this.miles = miles;
    }

    protected int getYear()
    {
        return year;
    }

    protected void setYear(int year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        String ret = "";

        ret += String.format("[%d] A '%d' '%s' '%s' with '%d' miles.", this.getCarId(), this.getYear(), this.getMake(), this.getModel(), this.getMiles());

        return ret;
    }

}
