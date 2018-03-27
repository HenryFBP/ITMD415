package Final.Product.Part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Product.GenericProduct;

@Entity
@Table(name = "Part")
public class Part implements GenericProduct
{
    @Id
    @Column(name = "partid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int partid;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "cond")
    private String condition;

    public Part(String make, String model, String type, String condition)
    {
        this.make = make;
        this.model = model;
        this.type = type;
        this.condition = condition;
    }

    public Integer getId()
    {
        return this.getPartid();
    }

    private Integer getPartid()
    {
        return partid;
    }

    protected void setPartid(int partid)
    {
        this.partid = partid;
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

    private String getCondition()
    {
        return condition;
    }

    private void setCondition(String condition)
    {
        this.condition = condition;
    }

    private String getType()
    {
        return type;
    }

    private void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        String ret = "";

        ret += String.format("[%d] A '%s' '%s' for a '%s' '%s'.", this.getPartid(), this.condition, this.type,
                this.make, this.model);

        return ret;
    }

}
