package Final.Product.Part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Part")
public class Part
{
    @Id
    @Column(name = "partid")
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

    private Integer getPartid()
    {
        return partid;
    }

    private void setPartid(int partid)
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

        ret += String.format("A '%s' '%s' for a '%s' '%s'.", this.condition, this.type, this.make, this.model);

        return ret;
    }

}
