package com.login4hq.action.account;


import org.apache.log4j.Logger;

import com.login4hq.dao.AccountAdminDAO;
import com.login4hq.dao.AccountAdmin;
import com.opensymphony.xwork2.ActionSupport;

public class AddUser extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AddUser.class);
	private String newuser;
	private String newpassword;
	public String execute(){
		logger.info("user : " + newuser + " password : " + newpassword);
		AddUserRunnable aur = new AddUserRunnable(newuser, newpassword);
		Thread t = new Thread(aur);
		t.start();
		logger.info("注册成功！");
		return SUCCESS;
	}

	public String getNewuser() {
		return newuser;
	}

	public void setNewuser(String newuser) {
		this.newuser = newuser;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	class AddUserRunnable implements Runnable {
		private String user;
		private String passWord;
		
		public AddUserRunnable(String user, String passWord){
			this.setUser(user);
			this.setPassWord(passWord);
		}
		
		public void run(){
			logger.info("线程注册中");
			AccountAdminDAO aadao = new AccountAdminDAO();
			AccountAdmin aa = new AccountAdmin();
			logger.info("user : " + user + " passWord : " + passWord);
			aa.setUser(user);
			aa.setPwdSalt(passWord);
			aadao.save(aa);
			logger.info("线程注册完毕");
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
	}

}
