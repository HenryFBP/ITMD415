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
		boolean success = false;
		int port = MathE.PORT.i();

		while(!success)
		{
			try
			{
				this.serverSocket = new ServerSocket(port, 1, InetAddress.getByName(bind));
				success = true;
			}
			catch(BindException be)
			{
				System.out.printf("Port %d already in use. ", port);
				System.out.printf("Trying port %d...\n", port + 1);

				port++;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/***
	 * Listen for a connection to be made from a client.
	 */
	private void listen()
	{
		String s = null;

		try
		{
			Socket client = this.serverSocket.accept(); // this is blocking
			String clientAddr = client.getInetAddress().getHostAddress();
			System.out.printf("New connection from %s", clientAddr);
		}
		catch(IOException e)
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

		System.out.printf("Running math socket at %s:%d", this.serverSocket.getInetAddress().toString(),
				this.serverSocket.getLocalPort());

		this.listen();
	}
}
