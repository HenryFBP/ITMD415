package lab2;

import javax.servlet.http.HttpServletRequest;

/***
 * @author Jarron Bailey - Came up with this cool idea. Thanks dude! I'm gonna
 *         use this programming pattern in the future.
 */

public class CustomerFormHandler
{
	public static Customer handleForm(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String zip = request.getParameter("zip");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");

		return new Customer(name, ssn, zip, email, street, city, state);
	}
}
