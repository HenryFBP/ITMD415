package testWebProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class lib
{
	/***
	 * @return A date that holds the value of when it was created.
	 */
	public static Date now()
	{
		return new Date(Instant.now().toEpochMilli());
	}
	
	public static ArrayList<?> iteratorToList(Iterator it)
	{
		ArrayList<Object> l = new ArrayList<Object>();
		
		while(it.hasNext())
		{
			l.add(it.next());
		}
		
		return l;
	}
	
	/***
	 * Wrap a String with an HTML tag.<br>
	 * Example: <pre><code>w("hello!","a") -> "&lt;a>hello!&lt;/a>"</pre></code>
	 */
	public static String wrap(String s, String tag)
	{
		return "<" + tag + ">" + s + "</" + tag + ">";
	}

	/***
	 * Wrap a String with an arbitrary number of HTML tags.<br>
	 * Example: <pre><code>w("ascii??","pre","code") -> &lt;pre>&lt;code>ascii??&lt;/pre>&lt;/code></pre></code>
	 */
	public static String wrap(String s, String... args)
	{
		String ret = s;
		
		for(int i = 0; i < args.length; i++) //for all elems
		{
			ret = wrap(ret, args[i]); //apply one elem
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
}
