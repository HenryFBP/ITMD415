package Final.ProductType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producttype")
public class ProductType
{
    @Id
    private int ptid;

    private String name;

    public Integer getPtid()
    {
        return ptid;
    }

    public void setPtid(int ptid)
    {
        this.ptid = ptid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
