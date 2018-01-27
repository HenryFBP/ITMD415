package lab1;

import java.io.IOException;
import java.net.*;

/***
 * A single math server socket class.
 */
public class MathServerSocket
{
	private ServerSocket serverSocket;
	private MathServer server;
	
	public MathServerSocket(String bind)
	{
		try
		{
			this.serverSocket = new ServerSocket(0, 1, InetAddress.getByName(bind));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void listen()
	{
		String s = null;
		
		try
		{
			Socket client = this.serverSocket.accept();
			String clientAddr = client.getInetAddress().getHostAddress();
			System.out.printf("New connection from %s",clientAddr);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public InetAddress getSocketAddress()
	{
		return this.serverSocket.getInetAddress();
	}
	
	public int getPort()
	{
		return this.serverSocket.getLocalPort();
	}
	
	public void start()
	{
		
		System.out.println("Running math socket.");
		System.out.printf("Host: %s\n",this.serverSocket.getInetAddress().toString());
		System.out.printf("Port: %d\n",this.serverSocket.getLocalPort());
		
		this.listen();
	}
}
