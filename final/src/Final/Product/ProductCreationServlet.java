package Final.Product;

import javax.servlet.http.HttpServletRequest;

import Final.Customer.Exceptions.FormNotFilledOutException;
import Final.Product.Car.CarHandler;
import Final.Product.Part.PartHandler;

public class ProductCreationServlet
{

    /***
     * Creates a new Product.
     * 
     * @param r
     *            The HTTP Request.
     * 
     * @return A Product.
     * 
     * @throws FormNotFilledOutException
     */
    public static Product createProduct(HttpServletRequest r) throws FormNotFilledOutException
    {
        String type = r.getParameter("type");
        
        if(CarHandler.isCar(type))
        {
            System.out.println("thems makin a car!");
        }
        else if(PartHandler.isPart(type))
        {
            System.out.println("thems makin a part!");
        }
        else
        {
            throw new FormNotFilledOutException("type");
        }

        return null;
    }

}
