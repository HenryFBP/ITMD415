package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInput;
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
			boolean keep = true;
			
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			
			String request;
			
			Message m = new Message();
			
			m.add(String.format("Welcome to %s's and %s's MATH SERVER!", MathE.NAMED.s(), MathE.NAMEH.s()));
			m.add(String.format("Enter (%s) to quit.", MathE.QUIT.s()));
			m.add(String.format("Valid operators: %s",Arrays.toString(MathE.VALID_OPS).replaceAll("[\\[\\]\\\"]", "")));
			
			m.send(out, true);
			
			this.log.println("Wrote beginning message.");

			// while we should keep going
			while(keep == true)
			{				
				this.log.printf("About to get a %d-long message from client %s...",length,this.toStringHP());
				
				for(int i = 0; i < length; i++)
				{
					this.log.printf("%s: %s\n", this.toStringHP(), request);			
				}
				
				out.println(request);
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
