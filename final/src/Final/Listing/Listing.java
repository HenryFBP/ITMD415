package Final.Listing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Final.Customer.Customer;
import Final.Forum.Forum;
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
	private Product product;

	/***
	 * The Customer selling this Product.
	 */
	private Customer seller;

	/***
	 * The Customer buying this Product.
	 */
	private Customer buyer;
	
	/***
	 * The Forum thread(s) associated with this Listing.
	 */
	private Forum forum;
	
	public Customer getSeller()
	{
		return seller;
	}

	public void setSeller(Customer seller)
	{
		this.seller = seller;
	}

	public Customer getBuyer()
	{
		return buyer;
	}

	public void setBuyer(Customer buyer)
	{
		this.buyer = buyer;
	}

}
