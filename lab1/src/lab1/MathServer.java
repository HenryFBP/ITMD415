package lab1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(MathE.PORT.i());
		
		System.out.println("Server started.");
		
		while(true)
		{
			Socket socket = null;
			ObjectOutputStream out = null;
			ObjectInputStream in = null;
			
			try
			{
				socket = ss.accept();
				
				out = new ObjectOutputStream(socket.getOutputStream());
				in = new ObjectInputStream(socket.getInputStream());
				

				System.out.printf("New client connected: %s\n", socket);

				System.out.println("Assigning new thread for client");

				// create a new thread object
				Thread t = new MathServerThread(socket, out, in);
				// Invoking the start() method
				t.start();
			}
			catch(Exception e)
			{
				socket.close();
			}
		} // end of infinite while loop
	}// end of main
}// end of class
