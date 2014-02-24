package com.login4hq.dao;

import java.util.Date;

import org.hibernate.Session;

import com.login4hq.utils.HibernateUtil;

public class AccountAdminHbDAO {
	
	private void save() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        AccountAdmin aa = new AccountAdmin();
        aa.setPwdSalt("111");
		aa.setUser("hq6");
        session.save(aa);

        session.getTransaction().commit();
    }
	
	public static void main(String[] args) {
		AccountAdminHbDAO mgr = new AccountAdminHbDAO();
        mgr.save();
        HibernateUtil.getSessionFactory().close();
    }

}
