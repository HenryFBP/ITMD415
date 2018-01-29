package lab1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			Message serverMsg = new Message();
			Message clientMsg = new Message();
			Statement s = null;

			serverMsg.add(String.format("Welcome to %s's and %s's MATH SERVER!", MathE.NAMED.s(), MathE.NAMEH.s()));
			serverMsg.add(String.format("Enter (%s) to quit.", MathE.QUIT.s()));
			serverMsg.add(String.format("Valid operators: %s",
					Arrays.toString(MathE.VALID_OPS).replaceAll("[\\[\\]\\\"]", "")));
			
			// send object initially
			out.writeObject(serverMsg);
			out.flush();
			
			this.log.println("Wrote beginning message.");

			boolean keep = true;
			
			// while we should keep going
			while(keep == true)
			{
				s = null; //set math statement to null
				serverMsg = null; //set out response to null

				clientMsg = (Message) in.readObject(); //get response
				
				if(clientMsg.length() <= 0) //if they want to quit
				{
					keep = false;
					System.out.printf("[%s]: Wants to quit.", this.toStringHP());
					break;
				}
				
				System.out.printf("[%s]: {%d}:'",this.toStringHP(), clientMsg.length()); //log what they send
				clientMsg.toString(System.out,";");
				System.out.print("' -> ");
				
				try //try to parse their request of math...
				{
					s = new Statement(clientMsg.flatten());
				}
				catch(Exception e) //it's invalid
				{
					serverMsg = new Message(String.format("Invalid request '%s'.",clientMsg.flatten()));
					System.out.print("INVALID");
				}
				
				if(s != null) //if math was successfully parsed
				{
					serverMsg = new Message(String.format("'%s' = %.2f",clientMsg.flatten(), s.result()));
					System.out.print(s.result());
				}
				
				out.writeObject(serverMsg); //output whatever our message is
				

				System.out.print("\n");

			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
			this.log.printf("Error reading/writing for client %s!\n", this.toStringHP());
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
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
