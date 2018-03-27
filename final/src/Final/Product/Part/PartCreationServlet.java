package Final.Product.Part;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Final.Customer.Exceptions.FormNotFilledOutException;

public class PartCreationServlet
{

    public static Part createPart(HttpServletRequest r) throws FormNotFilledOutException
    {
        String make = r.getParameter("make");
        String model = r.getParameter("model");
        String type = r.getParameter("type");
        String condition = r.getParameter("condition");

        ArrayList<String> problems = new ArrayList<String>();

        if(make == null || make.length() == 0)
        {
            problems.add("make");
        }

        if(model == null || model.length() == 0)
        {
            problems.add("model");
        }

        if(type == null || type.length() == 0)
        {
            problems.add("type");
        }

        if(condition == null || condition.length() == 0)
        {
            problems.add("condition");
        }

        if(!problems.isEmpty())
        {
            throw new FormNotFilledOutException(problems);
        }

        Part part = new Part(make, model, type, condition);
        
        PartHandler partHandler = new PartHandler();
        
        System.out.println("About to make this part:");
        System.out.println(part.toString());
        
        part.setPartid(partHandler.create(part)); //set part id to saved part
        
        return part;
    }

}
