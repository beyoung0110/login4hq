package com.login4hq.action.account;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	private String message;
	public String execute(){
		logger.info("message : " + message);
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
