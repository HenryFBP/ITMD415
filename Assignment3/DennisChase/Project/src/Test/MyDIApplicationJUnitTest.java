package Test;

import Consumer.Consumer;
import Consumer.MyDIApplication;
import Injector.MessageServiceInjector;
import Service.MessageService;

public class MyDIApplicationJUnitTest 
{
	private MessageServiceInjector injector;

	public void setUp(){
		//mock the injector with anonymous class
		
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication();
			}
		};
	}
	
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Dennis", "dchase3@hawk.iit.edu");
	}
	
	public void tear(){
		injector = null;
	}

}