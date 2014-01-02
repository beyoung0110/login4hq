package com.login4hq.dao;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class AccountAdminDAO extends AbstractDAO<AccountAdmin> {
	public String getClassName() {
        return getEntityClass().getName();
    }
	@Override
	public Class getEntityClass() {
		return AccountAdmin.class;
	}

	@Override
	public String getPUName() {
		return DAOConstants.PU_NAME;
	}

	@Override
	public IEntityManagerHelper getEntityManagerHelper() {
		return new NoCacheEntityManagerHelper();
	}

	public static void main(String[] args){
		AccountAdmin aa = new AccountAdmin();
		AccountAdminDAO aadao = new AccountAdminDAO();
		aa.setPwdSalt("111");
		aa.setUser("hq");
		aadao.save(aa);
	}
}
