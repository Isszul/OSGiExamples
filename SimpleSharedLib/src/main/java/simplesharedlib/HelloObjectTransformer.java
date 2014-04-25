package simplesharedlib;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;

@Converter
public class HelloObjectTransformer {

	@Converter
	public static HelloObject toHelloObject(String input, Exchange exchange) {
		return new HelloObject(input);
	}

	@Converter
	public static String toString(HelloObject input, Exchange exchange) {
		return input.getMsg();
	}

}
