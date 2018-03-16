package Injector;

import Consumer.Consumer;
import Consumer.MyDIApplication;
import Service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector
{
	@Override
	public Consumer getConsumer()
	{
		return new MyDIApplication();
	}
}
