package Final;

import com.amdelamar.jhash.Hash;

public class Lib
{
    /***
     * Hash a String.
     * @param s The String.
     * @return A hashed version of the String.
     */
    public static String hash(String s)
    {
        char[] str = s.toCharArray();

        String hash = Hash.password(str).create();

        return hash;
    }
}
