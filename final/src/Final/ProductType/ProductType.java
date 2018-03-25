package Final.ProductType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producttype")
public class ProductType
{
    @Id
    @Column(name = "ptid")
    private int ptid;

    @Column(name = "name")    
    private String name;

    private Integer getPtid()
    {
        return ptid;
    }

    private void setPtid(int ptid)
    {
        this.ptid = ptid;
    }

    private String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }
}
