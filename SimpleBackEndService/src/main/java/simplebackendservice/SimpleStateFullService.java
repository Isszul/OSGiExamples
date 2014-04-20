package simplebackendservice;

public class SimpleStateFullService implements ISimpleStateFullService {

	private int counter;

	public void start() throws Exception {
		counter = 0;
		System.out.println("Started stateful service counter = " + counter);
	}

	public void stop() throws Exception {
		System.out.println("Stopping stateful service counter = " + counter);
	}

	@Override
	public HelloObject hello(String msg) {
		return new HelloObject(++counter + " : Hello");
	}
}
