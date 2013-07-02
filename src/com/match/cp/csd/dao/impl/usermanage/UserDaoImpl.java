package com.match.cp.csd.dao.impl.usermanage;

import com.match.cp.csd.dao.dao.usermanage.UserDao;
import com.match.cp.domain.model.usermanage.UserModel;
import com.match.cp.domain.querymodel.usermanage.UserQueryModel;
import com.match.cp.framework.dao.AbstractDaoImpl;

public class UserDaoImpl extends AbstractDaoImpl<UserModel, UserQueryModel> implements UserDao{
	
	protected UserDaoImpl(Class<UserModel> clazz) {
		super(UserModel.class);
	}

}
