package simplebackendservice;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import simplesharedlib.HelloObject;

public class SimpleStateFullService implements ISimpleStateFullService,
		Processor {

	private int counter;

	public void start() throws Exception {
		counter = 0;
		System.out.println("Started stateful service counter = " + counter);
	}

	public void stop() throws Exception {
		System.out.println("Stopping stateful service counter = " + counter);
	}

	@Override
	public HelloObject hello(HelloObject msg) {
		System.out.println("BackEnd Called. " + msg);
		return new HelloObject(++counter + " : Hello from back end : " + msg.getMsg());
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();
		HelloObject returnObject = hello((HelloObject) in.getBody());

		Message out = exchange.getOut();
		out.setHeaders(in.getHeaders());
		out.setBody(returnObject, HelloObject.class);

	}
}
