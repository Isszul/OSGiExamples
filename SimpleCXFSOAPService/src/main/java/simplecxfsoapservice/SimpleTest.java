package simplecxfsoapservice;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import simplebackendservice.HelloObject;
import simplebackendservice.ISimpleStateFullService;

public class SimpleTest implements ISimpleTest {

	private ISimpleStateFullService simpleStateFullService;
	private CamelContext camelContext;

	@Override
	public String helloWorld() {

		HelloObject sendObject = new HelloObject("Hello from front end");

		// Spring DM
		// HelloObject helloObj = simpleStateFullService.hello(sendObject);

		try {

			ProducerTemplate producer = camelContext.createProducerTemplate();

			HelloObject helloObj = producer.requestBody("direct:hello.in",
					sendObject, HelloObject.class);

			return helloObj.getMsg();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Failed";
	}

	/**
	 * @return the simpleStateFullService
	 */
	public ISimpleStateFullService getSimpleStateFullService() {
		return simpleStateFullService;
	}

	/**
	 * @param simpleStateFullService
	 *            the simpleStateFullService to set
	 */
	public void setSimpleStateFullService(
			ISimpleStateFullService simpleStateFullService) {
		this.simpleStateFullService = simpleStateFullService;
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
