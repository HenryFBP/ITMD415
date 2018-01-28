package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MathServer extends Thread
{

	protected Socket socket;
	protected PrintStream log;
	
	private static void sendMessage(ArrayList<String> m, PrintWriter p)
	{
		p.println(m.size());
		for(String s : m)
		{
			p.println(s);
		}
	}
	
	private static void sendMessage(String s, PrintWriter p)
	{
		p.println(1);
		p.println(s);
	}
	
	private MathServer(Socket socket, PrintStream o)
	{
		this.socket = socket;
		this.log = o;
		log.printf("New Client: '%s'\n", this.toStringHP());
		this.run();
	}

	/***
	 * Called when a server-client connection is initiated.
	 */
	public void run()
	{
		try
		{

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			//OutputStream out = socket.getOutputStream();
			
			String request;

			ArrayList<String> m = new ArrayList<String>();

			m.add(String.format("Welcome to %s's and %s's MATH SERVER!\r\n", MathE.NAMED.s(), MathE.NAMEH.s()));
			m.add(String.format("Enter (%s) to quit.\r\n", MathE.QUIT.s()));
			m.add(String.format("Valid operators: %s\r\n",Arrays.toString(MathE.VALID_OPS).replaceAll("[\\[\\]\\\"]", "")));

			this.sendMessage(m, pw);
			
			this.log.println("Wrote beginning message.");

			// while we should keep going
			while(((request = br.readLine()) != null) && HLib.shouldContinue(request, MathE.QUIT.s()))
			{
				this.log.printf("%s: %s\n", this.toStringHP(), request);
				pw.println(request);
				//out.write(request.getBytes());
			}

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			this.log.printf("Error reading/writing for client %s!\n", this.toStringHP());
		}
		finally
		{
			try
			{
				socket.getInputStream().close();
				socket.getOutputStream().close();
				socket.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
	}

	/***
	 * Called to initiate the server.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Server starting.");
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(MathE.PORT.i());

			while(true) // blocking accept request FOREVER!!! :)
			{
				System.out.println("Waiting for client to connect...");
				new MathServer(server.accept(), System.out);
			}
		}
		catch(IOException ioe)
		{
			System.out.println("Error starting server.");
			ioe.printStackTrace();
		}

	}

	/***
	 * Return current connection to a string as "hostname:port".
	 * 
	 * @return host:port String of current MathServer connection.<br>
	 *         Example: "localhost:23532"
	 */
	public String toStringHP()
	{
		return String.format("%s:%d", this.socket.getInetAddress().toString(), this.socket.getPort());
	}
}
