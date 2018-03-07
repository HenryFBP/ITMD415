package Final.Customer.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class FormNotFilledOutException extends Exception
{
    public List<String> missing;

    public FormNotFilledOutException(String string)
    {
        this.missing = new ArrayList<String>();
        this.missing.add(string);
    }

    public FormNotFilledOutException(List<String> string)
    {
        this.missing = string;
    }

    /***
     * @return The list of missing form elements in an HTML list.
     */
    public String getList()
    {
        String ret = "<ul>";
        for(String string : this.missing)
        {
            ret += "<li><a>" + string + "</a></li>";
        }
        ret += "</ul>";
        return ret;
    }
}
