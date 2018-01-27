package lab1;

public class MathClient
{
	public static void main(String[] args)
	{
		Tests.runTests(); // test library funcs
		
		
		MathServerSocket mathServerSocket = new MathServerSocket("localhost");
		
		mathServerSocket.start();
		
	}
}
