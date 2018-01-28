package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MathClient
{
	private Socket s;

	public static void connect()
	{
		System.out.println("Connecting...");
		
		try(Socket sock = new Socket(MathE.HOST.s(), MathE.PORT.i()))
		{
			boolean keepgoing = true;
			
			System.out.println("Connected!");

			PrintWriter toServer = new PrintWriter(sock.getOutputStream()); // PrintWriter to server

			BufferedReader fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream())); // BufferedReader from server

			Scanner scan = new Scanner(System.in); // Scanner for user input
			String userInput = "";

			String resp = "";

			while(fromServer.ready())
			{
				resp += fromServer.readLine() + "\r\n";
			}

			System.out.print(resp); // get initial message

			while(keepgoing == true)
			{
				System.out.print(" > ");
				userInput = scan.nextLine(); // reads user input and saves it
				
					
				System.out.println("writing...");
				toServer.println(userInput); // sends user input to server
				System.out.println("done writing.");
				
				//check if they want to quit
				if(!HLib.shouldContinue(userInput.toUpperCase(), MathE.QUIT.s().toUpperCase()))
				{
					keepgoing = false;
				}

				
				System.out.println("reading...");
				
				while(!fromServer.ready())
				{
					//wait for server to be ready.
				}
				
				System.out.println("Server is ready!");
				
				resp = fromServer.readLine();
				
				System.out.println(resp); // displays servers response
				System.out.println("done reading.");
			}


			sock.close();
			toServer.close();
			fromServer.close(); // closes all open streams

			System.out.println("Connection terminated..."); // Signifies the end of the connection

		}
		catch(IOException e)
		{
			System.out.print("Client Error: " + e.getMessage());
		} // end of try/catch loop
	}//end of connect method
	
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
		connect();
	}// end of main
}// end of class
