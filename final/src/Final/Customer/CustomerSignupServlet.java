package Final.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Final.Lib;
import Final.Customer.Exceptions.CustomerAlreadyExistsException;
import Final.Customer.Exceptions.CustomerNameDoesNotExistException;
import Final.Customer.Exceptions.FormNotFilledOutException;
import Final.Customer.Exceptions.PasswordMismatchException;

public class CustomerSignupServlet
{

    /***
     * Creates a new Customer.
     * 
     * @param r The HTTP Request.
     * 
     * @return A Customer, if that customer can be created. If it cannot, i.e. the
     *         username is used or too small, it throws an exception.
     * 
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

        if(username == null || username.length() <= 0)
        {
            problems.add("username");
        }
        if(password == null || password.length() <= 0)
        {
            problems.add("password");
        }
        if(email == null || email.length() <= 0)
        {
            problems.add("email");
        }

        if(h.exists(username)) // customer already exists!
        {
            throw new CustomerAlreadyExistsException(username);
        }

        if(!problems.isEmpty()) // you ain't filled it out!
        {
            throw new FormNotFilledOutException(problems);
        }

        System.out.printf("Username: %s\n", username);
        System.out.printf("Password: %s\n", password);
        System.out.printf("Email: %s\n", email);

        Customer c = new Customer(username, email, password); // customer from their data

        h.create(c);

        return c;

    }

    /***
     * Attempts to log a person in from a POST request.
     * 
     * @param r
     * @return The Customer associated, if they exist.
     * @throws FormNotFilledOutException If they have not filled out the form
     *         enough.
     * @throws CustomerNameDoesNotExistException If the username they use doesn't
     *         map to a registered user.
     */
    public static Customer loginCustomer(HttpServletRequest r)
            throws FormNotFilledOutException, CustomerNameDoesNotExistException, PasswordMismatchException
    {
        CustomerHandler handler = new CustomerHandler();

        String username = r.getParameter("username");
        String password = r.getParameter("password");

        List<String> problems = new ArrayList<String>();

        if(username == null || username.length() <= 0)
        {
            problems.add("username");
        }
        if(password == null || password.length() <= 0)
        {
            problems.add("password");
        }
        if(!problems.isEmpty())
        {
            throw new FormNotFilledOutException(problems);
        }

        Customer c = handler.read(username);

        if(c == null) // that means that the username doesn't exist.
        {
            throw new CustomerNameDoesNotExistException(username);
        }

        String passHash = c.getPassHash(); // the db profile's pass hash

        Boolean samepass = Lib.verifyHash(password, passHash); // is the user's password right?

        if(!samepass) // passwords aren't the same.
        {
            throw new PasswordMismatchException(username);
        }

        return c; // guess they're ok!
    }
}
