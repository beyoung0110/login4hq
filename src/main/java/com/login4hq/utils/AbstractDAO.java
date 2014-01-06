package com.login4hq.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.free4lab.utils.sql.IEntityManagerHelper;

public abstract class AbstractDAO<T> {
	/**
     * 获取实体名称，内部使用
     * @return
     */
    public String getClassName() {
        return getEntityClass().getName();
    }
    /**
     * 获取实体类型，需要继承，内部使用
     * @return
     */
    public abstract Class getEntityClass();
	/**
     * 获取数据库持久单元名称，需要继承，内部使用
     * @return
     */
    public abstract String getPUName();
	/**
     * 获取JPA数据库管理器，需要继承，内部使用
     * @return
     */
    public abstract IEntityManagerHelper getEntityManagerHelper();

	protected EntityManager getEntityManager() {
        return getEntityManagerHelper().getEntityManager(getPUName());
    }
	
	protected Logger logger = null;

    protected Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }

    protected void log(String info, Level level, Throwable ex) {
        getLogger().log(level, info, ex);
    }
	/**
     * 保存一个数据库实例
     */
    @SuppressWarnings("unchecked")
    public void save(T entity) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("saving " + getClassName() + " instance", Level.INFO, null);
        try {
            em.persist(entity);
            log("save successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("save failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }

    }
	
}
