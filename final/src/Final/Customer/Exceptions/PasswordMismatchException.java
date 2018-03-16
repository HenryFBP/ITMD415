package Final.Customer.Exceptions;

public class PasswordMismatchException extends Exception
{
    public String name;

    public PasswordMismatchException(String string)
    {
        this.name = string;
    }
}
