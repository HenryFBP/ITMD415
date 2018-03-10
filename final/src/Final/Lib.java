package Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

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
     * @return A 64-bit number that holds how many seconds it is from the Java epoch.
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
     * @param ms
     *            Milliseconds.
     * @param f
     *            String format specifier.
     * @return
     */
    public static String epochMillisecondsToDate(long ms, String f)
    {
        return new SimpleDateFormat(f).format(new Date(ms));
    }

    /***
     * See {@link Lib#epochMillisecondsToDate(long, String)}.
     */
    public static String epochSecondsToDate(long ms, String f)
    {
        return epochMillisecondsToDate((ms * 1000), f);
    }

    /***
     * Given an HTML String, return all non-tag parts.
     * 
     * Example:
     * 
     * <pre>
     * <code>
     * {@link #unwrap(String) unwrap}("&lt;meta />&lt;h1>hey&lt;/h1>&lt;pre>&lt;a>hi!&lt;/a>&lt;/pre>"
     * ->
     * {"hey","hi!"}"
     * </pre></code>
     */
    public static String[] unwrap(String s)
    {
        Matcher m = Pattern.compile(">(.+?)</").matcher(s); // match stuff inside ">(hi)</"

        ArrayList<String> ret = new ArrayList<>();

        while(m.find())
        {
            String match = m.group(1);

            if(!match.contains("><"))
            {
                ret.add(match); // add if actually content
            }
        }

        return ret.toArray(new String[] {});

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
        if(tag.contains(" "))
        {
            return wrap(s, tag.split(" ")); // split tags
        }
        else
        {

            return "<" + tag + ">" + s + "</" + tag + ">";
        }
    }

    /***
     * Wrap a String with an arbitrary number of HTML tags.<br>
     * Example:
     * 
     * <pre>
     * <code>
     * {@link #wrap(String, String...) wrap}("ascii??","pre","code")
     * ->
     * &lt;pre>&lt;code>ascii??&lt;/pre>&lt;/code>
     * </pre>
     * </code>
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

    /***
     * Alternatively-argumented form of {@link #wrapAttr(String, String, String[], String[])}.
     * 
     * @see #wrapAttr(String, String, String[], String[])
     */
    public static String wrapAttr(String s, String tag, String attr, String val)
    {
        if(tag.contains(" ")) // tags separated by spaces
        {
            String[] tags = tag.split(" ");
            return wrapAttr(s, tags, attr, val);
        }
        else // only one tag
        {
            return wrapAttr(s, tag, new String[] { attr }, new String[] { val });
        }
    }

    /***
     * Alternatively-argumented form of {@link #wrapAttr(String, String, String[], String[])}.
     * 
     * @see #wrapAttr(String, String, String[], String[])
     */
    public static String wrapAttr(String s, String[] tags, String attr, String val)
    {

        String lastTag = (tags.length > 0 ? tags[tags.length - 1] : ""); // last tag OR nothing

        String[] leftovers = (tags.length > 1 ? Arrays.copyOfRange(tags, 0, tags.length - 1) : new String[] {}); // tags[0:end-1] OR nothing

        String ret = wrapAttr(s, lastTag, attr, val); // wrap it

        ret = wrap(ret, leftovers); // add leftover tags

        return ret;
    }

    /***
     * Wrap a String with an HTML tag and an arbitrary number of attribute-value pairs.<br>
     * Example:
     * 
     * <pre>
     * <code>
     * {@link #wrapAttr(String, String, String[], String[]) wrapAttr}("link to goggles", "a", new String[] { "href","checked" }, new String[] { "google.ru" }) <br>
     * -><br>
     * &lt;a href="google.ru" checked >link to goggles&lt;/a>
     * </code>
     * </pre>
     */
    public static String wrapAttr(String s, String tag, String[] attrs, String[] vals)
    {
        String ret = "<" + tag;

        for(int i = 0; i < attrs.length; i++)
        {
            ret += String.format(" %s", attrs[i]);
            if(i < vals.length)
            {
                ret += String.format("=\"%s\"", vals[i]);
            }
        }

        ret += ">";

        ret += s;

        ret += "</" + tag + ">";

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
        catch(InvalidHashException e)
        {
        }
        return false;

    }

    public static void main(String[] args)
    {
        String ugly = "        <li>\r\n          <label for=\"password\"> Password</label>\r\n"
                + "          <input type=\"password\" id=\"password\" name=\"password\"/>\r\n" + "        </li>\r\n"
                + "        <li class=\"form-two\">\r\n" + "          <label for=\"confirm\">Delete account</label>\r\n"
                + "          <a>To delete your account, type the following in the below box:</a>\r\n"
                + "          <pre id=\"important\"><code><%=confirm%></code></pre>";

        System.out.println("Hi, I'm main() of class '" + Lib.class.getCanonicalName() + "'. For testing.");

        System.out.println(wrap("im code bro", "pre", "code"));
        System.out.println(wrap(wrap("im code bro", "pre"), "code")); // many ways to skin a tag
        System.out.println(wrap("im code bro", "pre code"));

        System.out.println(
                wrapAttr("link to goggles", "a", new String[] { "href", "checked" }, new String[] { "google.ru" }));

        String[] matches = unwrap(ugly);

        System.out.println(ugly);
        System.out.println("->");

        for(String match : matches)
        {
            System.out.println(match);
        }

        for(String pass : passwords)
        {
            String hash = hash(pass);
            System.out.printf("'%s' --[tasty magic hash brown machine]--> '%s'\n", pass, hash);

            System.out.print("Does hash give password? ");
            System.out.println(verifyHash(pass, hash).toString());
        }
    }
    
    public static HttpServletResponse sendToLogin(HttpServletResponse r) throws IOException
    {
        r.sendRedirect("/final/login");
        return r;
    }

}
