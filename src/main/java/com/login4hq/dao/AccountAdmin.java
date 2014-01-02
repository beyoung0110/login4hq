package com.login4hq.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCOUNT_ADMIN database table.
 * */
@Entity
@Table(name="ACCOUNT_ADMIN")
public class AccountAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String pwdSalt;

	private String user;

    public AccountAdmin() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwdSalt() {
		return this.pwdSalt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}