package lab2;

import java.util.Scanner;

public class Validation
{

    public static boolean nameIsValid(String name)
    {
        return ((name.length() >= 4) & (name.length() <= 50));
    }// end of nameIsValid

    public static boolean sSecurityIsValid(String ss)
    {
        if(ss.length() != 11)
        {
            return false;
        }

        for(int i = 0; i <= ss.length(); i++)
        {
            if(i == 3 || i == 6)
            {
                if(!(ss.charAt(i) == '-'))
                {
                    return false;
                }
            }
            else
            {
                if(!(Character.isDigit(ss.charAt(i))))
                {
                    return false;
                }
            }
        }
        return true;
    }// end of sSecurityIsValid

    public static boolean zipIsValid(String zip)
    {
        if(zip.length() != 10)
        {
            return false;
        }

        for(int i = 0; i <= zip.length(); i++)
        {
            if(i == 5)
            {
                if(!(zip.charAt(i) == '-'))
                {
                    return false;
                }
            }
            else
            {
                if(!(Character.isDigit(zip.charAt(i))))
                {
                    return false;
                }
            }
        }
        return true;
    }// end of zipIsValid

    public static boolean emailIsValid(String email)
    {
        return email.length() < 7;
    }// end of emailIsValid

    public static boolean addressIsValid(String address)
    {
        return ((address.length() >= 4) & (address.length() <= 50));
    }// end of addressIsValid

    public static boolean cityIsValid(String city)
    {
        return ((city.length() >= 3) & (city.length() <= 50));
    }// end of cityIs Valid

    /***
     * To test our {@link Validation} class.
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String in = "";
        boolean valid = false;

        while(true)
        {
            System.out.println("Enter name: ");
            in = s.nextLine();
            valid = nameIsValid(in);

            if(valid)
            {
                break;
            }

            System.out.printf("Name '%s' not valid.\n", in);
        }

    }

}// end of class