package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class MathClient
{
	private Socket socket;

	public void connect(String host, int port)
	{
		System.out.printf("Connecting to '%s:%d'...", host, port);
		
		try
		{
			socket = new Socket(host, port);
					
			System.out.println("Connected to server!");

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); // ObjectOutputStream to server
			
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); // ObjectInputStream from server

			Scanner keyboard = new Scanner(System.in);
			String input = "";

			Message response = new Message();
						
			response = (Message)in.readObject(); //get message object
			
			System.out.printf("First response from server: '%s'\n",response.toString());
			

			boolean keepgoing = true;
			
			while(keepgoing == true)
			{
				response = (Message)in.readObject();

				if(response.length() == 0) //if they want to quit
				{
					keepgoing = false;
				}
			}


			socket.close();
			out.close();
			in.close(); // closes all open streams

			System.out.println("Connection terminated..."); // Signifies the end of the connection

		}
		catch(IOException e)
		{
			System.out.print("Client Error: " + e.getMessage());
			//System.exit(1);
		} // end of try/catch loop
		catch (ClassNotFoundException e)
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
