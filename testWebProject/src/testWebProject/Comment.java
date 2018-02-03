package testWebProject;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment
{
	public int cid;
	private String name;
	private String content;
	private Date date;
	
	public Comment()
	{
		
	}

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}


	
}
