package simplecxfsoapservice;

import javax.jws.WebService;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import simplesharedlib.HelloObject;

@WebService(endpointInterface = "simplecxfsoapservice.ISimpleTest")
public class SimpleTest implements ISimpleTest {

	private CamelContext camelContext;

	@Override
	public String helloWorld() {

		HelloObject sendObject = new HelloObject("Hello from front end");

		try {

			ProducerTemplate producer = camelContext.createProducerTemplate();

			HelloObject helloObj = producer.requestBody("direct:hello.in",
					sendObject, HelloObject.class);

			return helloObj.getMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Failed";
	}

	/**
	 * @return the camelContext
	 */
	public CamelContext getCamelContext() {
		return camelContext;
	}

	/**
	 * @param camelContext
	 *            the camelContext to set
	 */
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

}
