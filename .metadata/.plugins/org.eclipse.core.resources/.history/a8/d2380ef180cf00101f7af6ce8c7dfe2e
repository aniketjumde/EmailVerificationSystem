package com.auth.Factory;

import com.auth.service.PasswordResetService;
import com.auth.service.PasswordResetServiceImpl;

public class PasswordResetServiceFactory 
{
	private static PasswordResetService passwordResetService=null;

	private PasswordResetServiceFactory() {}
	
	public static PasswordResetService getPasswordResetServiceInstance()
	{
		if(passwordResetService==null)
		{
			passwordResetService=new PasswordResetServiceImpl();
		}
		
		return passwordResetService;
	}
}
