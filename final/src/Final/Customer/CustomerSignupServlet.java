package Final.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CustomerSignupServlet
{

    /***
     * Creates a new Customer.
     * 
     * @param r
     *            The HTTP Request.
     * @return A Customer, if that customer can be created. If it cannot, i.e. the
     *         username is used or too small, it throws an exception.
     * @throws CustomerAlreadyExistsException
     * @throws FormNotFilledOutException
     */
    public static Customer createCustomer(HttpServletRequest r)
            throws CustomerAlreadyExistsException, FormNotFilledOutException
    {

        CustomerHandler h = new CustomerHandler();

        String username = r.getParameter("username");
        String password = r.getParameter("password");
        String email = r.getParameter("email");
        List<String> problems = new ArrayList<String>();
        
        if (username == null)
        {
            problems.add("username");
        }
        if (password == null)
        {
            problems.add("password");
        }
        if (email == null)
        {
            problems.add("email");
        }
        
        if(!problems.isEmpty())
        {
            throw new FormNotFilledOutException(problems);
        }

        System.out.printf("Username: %s\n", username);
        System.out.printf("Password: %s\n", password);
        System.out.printf("Email: %s\n", email);

        if (h.exists(username))
        {
            throw new CustomerAlreadyExistsException(username);
        }

        Customer c = new Customer(username, email, password);

        h.create(c);

        return c;

    }
}
