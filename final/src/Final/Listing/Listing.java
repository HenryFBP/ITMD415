package Final.Listing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Final.Customer.Customer;
import Final.Product.Product;

/***
 * A Listing of a single Product.
 */

@Entity
@Table(name = "listing")
public class Listing

{

    /***
     * The listing ID.
     */
    @Id
    private int lid;

    /***
     * The Product being sold under this Listing.
     */
    @OneToOne
    @JoinColumn(name = "pid")
    private Product product;

    /***
     * The Customer buying this Product. Can be Null if it has not been purchased.
     */
    @OneToOne
    @JoinColumn(name = "buyercid", unique = false, nullable = true)
    private Customer buyer;

    private Customer getBuyer()
    {
        return buyer;
    }

    private void setBuyer(Customer buyer)
    {
        this.buyer = buyer;
    }

}
