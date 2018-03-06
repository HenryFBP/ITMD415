package Final.Customer;

import javax.servlet.http.HttpServletRequest;

public class CustomerSignupServlet
{

    /***
     * Creates a new Customer
     * @param r The HTTP Request.
     * @return A Customer, if that customer can be created.
     * If it cannot, i.e. the username is used or too small, it returns null.
     */
    public static Customer createCustomer(HttpServletRequest r)
    {
        
        String username = r.getParameter("username");
        String password = r.getParameter("password");
        String email = r.getParameter("email");
        
        System.out.println("OH NO LOL UR PASSWORD IZ '"+password+"'! HAHAHA");
        
        return null;

    }
}
