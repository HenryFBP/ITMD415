package lab1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/***
 * A class that represents a message.<br>
 * 
 * This class was made because the PrintWriter and BufferedReader are both<br>
 * blocking, and to avoid blocking, this class sends object through an
 * ObjectOutputStream.<br>
 * <br>
 * Example:<br>
 * 
 * <pre>
 * <code>
 * Sending AL{"hello","world"} -> {
 * 	pw.printLine("2\r\n");
 * 	pw.printLine("hello\r\n");
 * 	pw.printLine("world\r\n");
 * 	return;
 * }
 * </pre></code>
 *
 */
public class Message
{
	private ArrayList<String> contents;

	public Message()
	{

	}

	public Message(String s)
	{
		ArrayList<String> a = new ArrayList<>();
		a.add(s);

		this.contents = a;
	}

	public Message(ArrayList<String> a)
	{
		for (int i = 0; i < a.size(); i++)
		{
			this.add(a.get(i));
		}
	}

	/***
	 * Sends self as a message to an ObjectOutputStream.<br>
	 * 
	 * @param out
	 */
	public void send(ObjectOutputStream out)
	{
		try
		{
			out.writeObject(this.clone());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}

	/***
	 * @see {@link Message#send(ObjectOutputStream)}
	 */
	public void send(ObjectOutputStream out, boolean v)
	{
		if (v == true)
		{
			System.out.println("Sending this: ");
			System.out.println(this.toString());
		}

		this.send(out);
	}

	/**
	 * Add a piece to this message.<br>
	 * All newlines will be removed from this message.<br>
	 * 
	 * @param s
	 *            The piece.
	 */
	public void add(String s)
	{
		contents.add(HLib.sanitize(s));
	}

	public String get(int i)
	{
		return contents.get(i);
	}

	public int length()
	{
		return this.contents.size();
	}

	public String toString()
	{
		String ret = String.format("Message[%d]: ", this.length());

		for (int i = 0; i < this.length(); i++)
		{
			ret += String.format(HLib.maxLength(this.length(), "d") + ": %s", i, this.get(i));
		}

		return ret;
	}
}
