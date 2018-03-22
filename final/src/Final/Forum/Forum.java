package Final.Forum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Customer.Customer;
import Final.Listing.Listing;

@Entity
@Table(name = "forum")
public class Forum
{
    @Id
    @Column(name = "fid")
    private int fid;

    /***
     * The Listing that this Forum thread is about.
     */
    private Listing listing;

    /***
     * The Customer posting on this Forum thread.
     */
    private Customer poster;

    private int date;

    private String message;

    public int getDate()
    {
        return date;
    }

    public void setDate(int date)
    {
        this.date = date;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}