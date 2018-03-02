package Final.ProductType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "producttype")
public class ProductType
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ptid;

	private String name;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ptid")
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
