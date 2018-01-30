package lab1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MathClient
{
	private Socket socket = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	public MathClient(String host, int port)
	{
		this.connect(host, port);
	}
	
	public MathClient(Socket s)
	{
		this.socket = s;
	}
	
	public void connect(String host, int port)
	{
		// if we already have a connection, don't connect
		if(socket != null && !socket.isClosed())
		{
			return;
		}

		System.out.printf("Connecting to '%s:%d'\n", host, port);

		try
		{
			socket = new Socket(host, port);
			System.out.println("Connected to server!");

			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("I/O Streams established.");
		}
		catch(IOException e)
		{
			System.out.println("Client Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void disconnect() throws IOException
	{
		socket.close();
	}
	
	/***
	 * Initiate a command-line REPL that interfaces with a math server.
	 */
	public void repl()
	{
		Scanner keyboard = new Scanner(System.in);

		String input = "";

		Message serverMsg = new Message();
		Message clientMsg = new Message();

		boolean keepgoing = true;

		while(keepgoing == true)
		{
			try
			{
				serverMsg = (Message) in.readObject(); // read message from server

				if(serverMsg.length() == 0) // if server wants to disconnect or we want to quit
				{
					System.out.println("Server wishes to terminate connection.");
					keepgoing = false;
					break;
				}
				else if(!HLib.shouldContinue(input.toUpperCase(), MathE.QUIT.s().toUpperCase()))
				{
					// prepare our quit signal
					clientMsg = new Message();
					out.writeObject(clientMsg);
					out.flush();

					System.out.println("Goodbye!");
					keepgoing = false;
					break;
				}

				serverMsg.toString(System.out); // print that message

				// prepare message from keyboard
				System.out.print(" > ");
				clientMsg = new Message(input = keyboard.nextLine());

				out.writeObject(clientMsg); // send message
				out.flush();

			}
			catch(EOFException e)
			{
				System.out.println("Server's message terminated unexpectedly.");
				e.printStackTrace();
			}
			catch(IOException e)
			{
				System.out.println("I/O Exception occurred.");
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}

		}

		// close open streams
		keyboard.close();
		
		try
		{
			socket.close();
		}
		catch(IOException e)
		{
			System.out.println("Closing socket failed.");
			e.printStackTrace();
		}


		System.out.println("Connection terminated."); // Signifies the end of the connection

	}

	/***
	 * Has a client ask a server for the result of (opa op opb).
	 * @param opa Operand a.
	 * @param op  Operation op.
	 * @param opb Operand b.
	 * @return opa op opb
	 * 
	 * Example:
	 * c(2.0, "**", 3.0) -> magic server math -> 8.0
	 */
	public double calculate(double opa, String op, double opb)
	{
		Message query = new Message(opa+op+opb);
		Message response = null;
		
		try
		{
			out.writeObject(query); // send question
			out.flush();
			response = (Message) in.readObject(); // recieve response
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		
		return (Double)response.result;
	}

	/***
	 * Command-line interface to server.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MathClient replMathClient = new MathClient(MathE.HOST.s(), MathE.PORT.i());

		replMathClient.repl();
	}
}
