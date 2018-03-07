package Final;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

public class Lib
{

    public static final String[] passwords = { "youwillneverguess", "youmayguess", "itsatrap", "trueadmin" };

    /***
     * Hash a String.
     * 
     * @param s
     *            The String.
     * @return A hashed version of the String.
     */
    public static String hash(String s)
    {
        char[] str = s.toCharArray();

        String hash = Hash.password(str).create();

        return hash;
    }

    /***
     * Verify that a hash String was created from a normal String.
     * 
     * @param string
     *            The normal String.
     * @param hash
     *            The hash String.
     * @return Whether or not the hash String created the normal String.
     */
    public static Boolean verifyHash(String string, String hash)
    {
        try
        {
            return Hash.password(string.toCharArray()).verify(hash);
        }
        catch (InvalidHashException e)
        {
        }
        return false;

    }

    public static void main(String[] args)
    {
        for (String pass : passwords)
        {
            String hash = hash(pass);
            System.out.printf("'%s' --[tasty magic hash brown machine]--> '%s'\n",pass,hash);
            
            System.out.print("Does hash give password? ");
            System.out.println(verifyHash(pass, hash).toString());
        }
    }
}
