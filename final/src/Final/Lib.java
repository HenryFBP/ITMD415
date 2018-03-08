package Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

public class Lib
{
    /***
     * @return A date that holds the value of when it was created.
     */
    public static Date now()
    {
        return new Date(Instant.now().toEpochMilli());
    }

    /***
     * @return A 64-bit number that holds how many seconds it is from the Java
     *         epoch.
     */
    public static long nowEpochSecond()
    {
        return now().toInstant().getEpochSecond();
    }

    public static ArrayList<?> iteratorToList(Iterator<?> it)
    {
        ArrayList<Object> l = new ArrayList<Object>();

        while(it.hasNext())
        {
            l.add(it.next());
        }

        return l;
    }

    /***
     * Return a formatted String from a Java epoch milliseconds value.
     * 
     * @param ms Milliseconds.
     * @param f String format specifier.
     * @return
     */
    public static String epochMillisecondsToDate(long ms, String f)
    {
        return new SimpleDateFormat(f).format(new Date(ms));
    }

    /***
     * See {@link lib#epochMillisecondsToDate(long, String)}.
     */
    public static String epochSecondsToDate(long ms, String f)
    {
        return epochMillisecondsToDate((ms * 1000), f);
    }

    /***
     * Wrap a String with an HTML tag.<br>
     * Example:
     * 
     * <pre>
     * <code>w("hello!","a") -> "&lt;a>hello!&lt;/a>"</pre></code>
     */
    public static String wrap(String s, String tag)
    {
        return "<" + tag + ">" + s + "</" + tag + ">";
    }

    /***
     * Wrap a String with an arbitrary number of HTML tags.<br>
     * Example:
     * 
     * <pre>
     * <code>w("ascii??","pre","code") -> &lt;pre>&lt;code>ascii??&lt;/pre>&lt;/code></pre></code>
     */
    public static String wrap(String s, String... args)
    {
        String ret = s;

        for(int i = args.length - 1; i >= 0; i--) // for all elems
        {
            ret = wrap(ret, args[i]); // apply one elem
        }

        return ret;
    }

    public static double randomNumber()
    {
        return (new Random()).nextDouble() * 100;
    }

    public static String fileToString(String s)
    {
        return fileToString(new File(s));
    }

    public static String fileToString(File f)
    {
        Scanner s = null;
        String line = "";
        String lines = "";

        try
        {
            s = new Scanner(f);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            return "";
        }

        while(s.hasNext())
        {
            line = s.nextLine();
            lines += line;
        }

        s.close();

        return lines;
    }

    public static final String[] passwords = { "youwillneverguess", "youmayguess", "itsatrap", "trueadmin" };

    /***
     * Hash a String.
     * 
     * @param s The String.
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
     * @param string The normal String.
     * @param hash The hash String.
     * @return Whether or not the hash String created the normal String.
     */
    public static Boolean verifyHash(String string, String hash)
    {
        try
        {
            return Hash.password(string.toCharArray()).verify(hash);
        }
        catch(InvalidHashException e)
        {
        }
        return false;

    }

    public static void main(String[] args)
    {
        System.out.println("Hi, I'm main() of class '" + Lib.class.getCanonicalName() + "'. For testing.");

        System.out.println(wrap("im code bro", "pre", "code"));

        for(String pass : passwords)
        {
            String hash = hash(pass);
            System.out.printf("'%s' --[tasty magic hash brown machine]--> '%s'\n", pass, hash);

            System.out.print("Does hash give password? ");
            System.out.println(verifyHash(pass, hash).toString());
        }
    }
}
