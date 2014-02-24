package com.login4hq.action.account;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.login4hq.dao.AccountAdminDAO;
import com.login4hq.dao.AccountAdmin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCheckAction extends ActionSupport{
	private static final Logger logger = Logger.getLogger(LoginCheckAction.class);
	private String user;
	private String passwordMd5;
	private String redirectUrl;
	
	private String message;
	
	public String execute(){
		/*AccountAdminDAO aadao = new AccountAdminDAO();
		List<AccountAdmin> aa = aadao.findByProperty("user", user);
		if(aa != null && aa.size() > 0){
			String password = aa.get(0).getPwdSalt();
			if(passwordMd5.equals(password)){
				redirectUrl = "/hq/alice";
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("user", "admin");
			}else{
				setMessage("密码错误");
				try {
					message = java.net.URLEncoder.encode(message,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return INPUT;
			}
		}else{
			setMessage("用户名错误");
			try {
				message = java.net.URLEncoder.encode(message,"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return INPUT;
		}
		return SUCCESS;*/
			
			
			
		if(user.equals("admin")){
			if(passwordMd5.equals("123")){
				redirectUrl = "/hq/alice";
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("user", "admin");
			}else{
				setMessage("密码错误");
				try {
					message = java.net.URLEncoder.encode(message,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return INPUT;
			}
		}else{
			setMessage("用户名错误");
			try {
				message = java.net.URLEncoder.encode(message,"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return INPUT;
		}
		return SUCCESS;
	}

	public String getPasswordMd5() {
		return passwordMd5;
	}

	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
