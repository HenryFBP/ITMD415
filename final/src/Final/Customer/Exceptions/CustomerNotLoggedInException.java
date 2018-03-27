package Final.Customer.Exceptions;

public class CustomerNotLoggedInException extends Exception
{
    public String message;

    public CustomerNotLoggedInException(String s)
    {
        this.message = s;
    }

    public CustomerNotLoggedInException()
    {

    }

}
