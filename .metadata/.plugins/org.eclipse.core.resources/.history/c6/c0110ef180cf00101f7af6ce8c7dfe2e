package com.auth.Factory;

import com.auth.dao.EmailVerificationDAO;
import com.auth.dao.EmailVerificationDAOImpl;

public class EmailVerificationDaoFactory 
{
	private static EmailVerificationDAO emailVarificationDao=null;
	
	private EmailVerificationDaoFactory() {}
	
	public static EmailVerificationDAO getEmailVerificationDaoInstance()
	{
		
		if(emailVarificationDao==null)
		{
			emailVarificationDao=new EmailVerificationDAOImpl();
		}
		
		return emailVarificationDao;
	}

}
