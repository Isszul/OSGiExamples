package simplebackendservice;

import java.io.Serializable;

public class HelloObject implements Serializable {

	private static final long serialVersionUID = -7517058162742469153L;
	private String msg;

	public HelloObject(String msg) {
		this.setMsg(msg);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
