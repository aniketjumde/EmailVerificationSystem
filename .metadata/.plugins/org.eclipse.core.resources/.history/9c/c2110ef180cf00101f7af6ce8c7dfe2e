package com.auth.Factory;

import com.auth.dao.LoginAttemptDAO;
import com.auth.dao.LoginAttemptDAOImpl;

public class LoginAttemptDaoFactory 
{
	private static LoginAttemptDAO loginAttemptDao=null;

	private LoginAttemptDaoFactory() { }
	
	public static LoginAttemptDAO getLoginAttemptDAOInstance()
	{
		if(loginAttemptDao==null)
		{

			loginAttemptDao=new LoginAttemptDAOImpl();
		}
		
		return loginAttemptDao;
	}
}
