package com.auth.Factory;

import com.auth.dao.PasswordResetDAO;
import com.auth.dao.PasswordResetDAOImpl;

public class PasswordResetDaoFactory 
{
	private static PasswordResetDAO passwordResetDao;
	
	private PasswordResetDaoFactory() { }
	
	public static PasswordResetDAO getPasswordResetDAOInstance()
	{
		
		if(passwordResetDao==null)
		{
			passwordResetDao=new PasswordResetDAOImpl();
		
		}
		
		return passwordResetDao;
	}
}
