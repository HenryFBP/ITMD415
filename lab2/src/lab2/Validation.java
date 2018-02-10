package lab2;

import java.util.*;

public class Validation
{

	public boolean nameIsValid(String name)
    {
        if((name.length() >= 4) & (name.length() <= 50))
        {
            return true;
        }
        else()
        {
            return false;
        }
    }//end of nameIsValid

    public boolean sSecurityIsValid(String ss)
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
            return true;
        }
    }//end of sSecurityIsValid

    public boolean zipIsValid(String zip)
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
            return true;
        }
    }//end of zipIsValid

    public boolean emailIsValid(String email)
    {
        if(email.length() < 7)
        {
            return false;
        }
        else
        {
            return ture;
        }
    }//end of emailIsValid

    public boolean addressIsValid(String address)
    {
        if((address.length() >= 4) & (address.length() <= 50))
        {
            return true;
        }
        else()
        {
            return false;
        }
    }//end of addressIsValid

    public boolean cityIsValid(String city)
    {
        if((city.length() >= 3) & (city.length() <= 50))
        {
            return true;
        }
        else()
        {
            return false;
        }
    }//end of cityIs Valid

}//end of class