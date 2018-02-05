package testWebProject.Comment;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment implements Serializable
{
	@Id @GeneratedValue
	private long cid;
	private String name;
	private String content;
	private Date date;

	public Comment()
	{

	}

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCid()
	{
		return cid;
	}

	public void setCid(long dEFAULT_ID)
	{
		this.cid = dEFAULT_ID;
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
