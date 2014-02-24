package com.login4hq.dao;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class AccountAdminJapDAO<T> {
	
	/*不会用
	 * @PersistenceContext(unitName="HqLoginPU")
	private EntityManager manager;*/
	
	public void save(T entity) {
		 /**
         * 普通方法
         */
		 EntityManager manager = Persistence.createEntityManagerFactory("HqLoginPU").createEntityManager();
		/**
         * 实验室方法
         */
        //EntityManager manager = new NoCacheEntityManagerHelper().getEntityManager("HqLoginPU");
		 if (manager.getTransaction().isActive()) {
			manager.getTransaction().rollback();
		 	System.out.println("A transaction is still active before another begin, we have to roll back it!");
		 }
		 
		 manager.getTransaction().begin();
		 System.out.println("saving " + entity.getClass().getName() + " instance");
			try {
				manager.persist(entity);
				System.out.println("save successful");
				manager.getTransaction().commit();
			} catch (RuntimeException re) {
				System.out.println("save failed");
				manager.getTransaction().rollback();
			    throw re;
			}
	 }
		
	public static void main(String[] args) {		 
        AccountAdmin aa = new AccountAdmin();
        aa.setPwdSalt("111");
		aa.setUser("hq5");
		AccountAdminJapDAO<AccountAdmin> aadao = new AccountAdminJapDAO<AccountAdmin>();
		aadao.save(aa);
    }
}
