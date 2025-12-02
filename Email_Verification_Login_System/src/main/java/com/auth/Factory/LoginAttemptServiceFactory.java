package com.auth.Factory;

import com.auth.service.LoginAttemptService;
import com.auth.service.LoginAttemptServiceImpl;

public class LoginAttemptServiceFactory 
{
	private static LoginAttemptService loginAttemptService=null;
	
	private LoginAttemptServiceFactory() {}
	
	public static LoginAttemptService getLoginAttemptServiceInstance()
	{
		if(loginAttemptService==null)
		{
			loginAttemptService=new LoginAttemptServiceImpl();
			
		}
		
		return loginAttemptService;
	}
	
	
}
