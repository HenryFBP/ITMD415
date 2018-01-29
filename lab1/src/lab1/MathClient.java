package lab1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MathClient
{
	private Socket socket;

	public void connect(String host, int port)
	{
		System.out.printf("Connecting to '%s:%d'\n", host, port);

		try
		{
			socket = new Socket(host, port);

			System.out.println("Connected to server!");

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); // ObjectOutputStream to server
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); // ObjectInputStream from server

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
						//prepare our quit signal
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
					return;
				}

			}

			// close open streams
			keyboard.close();
			socket.close();
			out.close();
			in.close();

			System.out.println("Connection terminated..."); // Signifies the end of the connection

		}
		catch(IOException e)
		{
			System.out.println("Client Error: " + e.getMessage());
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public int calculate(int opa, String op, int opb)
	{
		return -1;
	}

	/***
	 * Command-line interface to server.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MathClient mathClient = new MathClient();

		mathClient.connect(MathE.HOST.s(), MathE.PORT.i());
	}
}
