package com.auth.Factory;

import com.auth.service.EmailVerificationService;
import com.auth.service.EmailVerificationServiceImpl;

public class EmailVerificationServiceFactory 
{
	private static EmailVerificationService emailVerificationService=null;
	
	private EmailVerificationServiceFactory() {}
	
	public static EmailVerificationService getEmailVerificationServiceInstance()
	{
		if(emailVerificationService==null)
		{
			emailVerificationService=new EmailVerificationServiceImpl();
		}
		
		return emailVerificationService;
	}

}
