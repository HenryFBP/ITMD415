package testWebProject.Comment;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import testWebProject.lib;

@Entity
@Table(name = "comment")
public class Comment implements Serializable
{
	private static final long serialVersionUID = 1379680211260170637L;
	
	@Id @GeneratedValue
	private Long cid;
	private String name;
	private String content;
	private Date date;

	public Comment()
	{
		this.name = "Randy Random";
		this.content = "I am a test person. hooray!";
		this.date = (Date) lib.now();
	}
	
	public Comment(Long cid, String n, String c, Date d)
	{
		this.cid = cid;
		this.name = n;
		this.content = c;
		this.date = d;
	}
	
	public Comment(String n, String c, Date d)
	{
		this.name = n;
		this.content = c;
		this.date = d;		
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "comment_id")
	public long getCid()
	{
		return cid;
	}

	public void setCid(long cid)
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
	
	@Override
	public String toString()
	{
		String ret = "";

		ret += String.format("%s on %s: '%s'",this.getName(),DateFormat.getDateInstance().format(this.getDate()),this.getContent());
		
		return ret;
	}
	
	/***
	 * Copy all attributes from another comment into self.
	 * @param c The other comment.
	 */
	public void deepCopy(Comment c)
	{
		this.setCid(c.getCid());
		this.setName(c.getName());
		this.setContent(c.getContent());
		this.setDate(c.getDate());
	}

}
