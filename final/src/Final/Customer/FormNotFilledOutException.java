package Final.Customer;

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
}
