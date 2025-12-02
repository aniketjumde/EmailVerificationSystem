package com.auth.Factory;

import com.auth.service.UserService;
import com.auth.service.UserServiceImpl;

public class UserServiceFactory 
{
	private static UserService userService=null;
	
	private UserServiceFactory() {}
	
	public static UserService getUserServiceFactory()
	{
		if(userService==null)
		{
			userService=new UserServiceImpl();
		}
		
		return userService;
	}

}
