package Injector;

import Consumer.Consumer;
import Consumer.MyDIApplication;
import Service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector 
{
	@Override
	public Consumer getConsumer()
	{
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}
}
