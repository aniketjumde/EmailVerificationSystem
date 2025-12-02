package com.auth.Factory;

import com.auth.dao.UserDao;
import com.auth.dao.UserDaoImpl;

public class UserDaoFactory 
{
	private static UserDao userDao=null;
	
	private UserDaoFactory() {}
	
	public static UserDao getUserDaoFactory()
	{
		if(userDao==null)
		{
			userDao=new UserDaoImpl();
		}
		
		return userDao;
	}
}
