package Final.Forum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "lid")
    private Listing listing;

    /***
     * The Customer posting on this Forum thread.
     */
    @ManyToOne
    @JoinColumn(name = "postercid")
    private Customer poster;

    @Column(name = "date")
    private int date;

    @Column(name = "message")
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
