package Test;

import Consumer.Consumer;
import Injector.EmailServiceInjector;
import Injector.MessageServiceInjector;
import Injector.SMSServiceInjector;

public class MyMessageDITest 
{
	public static void main(String[] args)
	{
		String msg = "Hi Dennis";
		String email = "dchase3@hawk.iit.edu";
		String phone = "123456789";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}
}
