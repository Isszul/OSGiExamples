package simplecxfsoapservice;

import simplebackendservice.HelloObject;
import simplebackendservice.ISimpleStateFullService;

public class SimpleTest implements ISimpleTest {

	private ISimpleStateFullService simpleStateFullService;

	@Override
	public String helloWorld() {
		HelloObject helloObj = simpleStateFullService.hello("Hello");
		return helloObj.getMsg();
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

}
