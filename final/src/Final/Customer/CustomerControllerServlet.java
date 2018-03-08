package Final.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerControllerServlet
 */
@WebServlet("/CustomerControllerServlet")
public class CustomerControllerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /***
     * Given an HttpSession, generate a status that tells the user whether or not
     * they're logged in.
     */
    public static String generateStatus(HttpSession s)
    {

        String fail = "Not currently logged in.";

        if(s == null)
        {
            return fail;
        }

        try
        {
            String name = (String) s.getAttribute("username");
            if(name != null)
            {
                return String.format("Welcome, %s!", name);
            }
        }
        catch(IllegalStateException e) // session has just been invalidated or something
        {
            System.out.println("you " + e.getClass().getCanonicalName() + " class bro???");
            return fail;
        }

        return fail;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerControllerServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        response.getWriter().append("customer controller servlet. hi. u wanna login??? :>)");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
