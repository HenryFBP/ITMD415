package Final.Customer.Exceptions;

public class CustomerNameDoesNotExistException extends Exception
{
    public String name;
    
    public CustomerNameDoesNotExistException(String string)
    {
        this.name = string;
    }
}
