package Final;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

public class Lib
{
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
     * @param s
     *            The normal String.
     * @param h
     *            The hash String.
     * @return Whether or not the hash String created the normal String.
     */
    public static Boolean verifyHash(String s, String h)
    {
        try
        {
            return Hash.password(s.toCharArray()).verify(h);
        }
        catch (InvalidHashException e)
        {
        }
        return false;

    }
}
