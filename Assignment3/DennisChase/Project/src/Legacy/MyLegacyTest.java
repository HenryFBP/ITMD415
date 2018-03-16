package Legacy;

public class MyLegacyTest 
{
	public static void main (String[] args)
	{
		MyApplication app = new MyApplication(new EmailService());
		app.processMessages("Hola holigan", "dchase3@hawk.iit.edu");
	}
}
