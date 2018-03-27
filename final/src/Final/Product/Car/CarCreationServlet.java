package Final.Product.Car;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Final.Lib;
import Final.Customer.Exceptions.FormNotFilledOutException;

public class CarCreationServlet
{

    public static Car createCar(HttpServletRequest r) throws FormNotFilledOutException
    {
        String make = r.getParameter("make");
        String model = r.getParameter("model");
        Integer miles = Lib.parseIntN(r.getParameter("miles"));
        Integer year = Lib.parseIntN(r.getParameter("year"));

        ArrayList<String> problems = new ArrayList<String>();

        if(make == null || make.length() == 0)
        {
            problems.add("make");
        }

        if(model == null || model.length() == 0)
        {
            problems.add("model");
        }

        if(miles == null)
        {
            problems.add("miles");
        }

        if(year == null)
        {
            problems.add("year");
        }

        if(!problems.isEmpty())
        {
            throw new FormNotFilledOutException(problems);
        }

        Car car = new Car(make, model, miles, year);

        CarHandler carHandler = new CarHandler();

        System.out.println("About to make this car:");
        System.out.println(car.toString());

        car.setCarId(carHandler.create(car)); // set part id to saved part

        return car;
    }

}
