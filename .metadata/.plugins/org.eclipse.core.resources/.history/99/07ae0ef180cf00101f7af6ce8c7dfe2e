package com.auth.service;

import com.auth.Factory.LoginAttemptDaoFactory;
import com.auth.Model.LoginAttempt;
import com.auth.dao.LoginAttemptDAO;

public class LoginAttemptServiceImpl implements LoginAttemptService
{

	@Override
	public LoginAttempt findByEmail(String email) 
	{
		LoginAttemptDAO loginAttemptDao=LoginAttemptDaoFactory.getLoginAttemptDAOInstance();
		return loginAttemptDao.findByEmail(email.toLowerCase());
	}

	@Override
	public void saveOrUpdate(LoginAttempt attempt) 
	{
		LoginAttemptDAO loginAttemptDao=LoginAttemptDaoFactory.getLoginAttemptDAOInstance();
		loginAttemptDao.saveOrUpdate(attempt);
	}

	@Override
	public void resetAttempts(String email) 
	{
		LoginAttemptDAO loginAttemptDao=LoginAttemptDaoFactory.getLoginAttemptDAOInstance();
		loginAttemptDao.resetAttempts(email);
	}

	@Override
	public void cleanupOldAttempts() 
	{
		LoginAttemptDAO loginAttemptDao=LoginAttemptDaoFactory.getLoginAttemptDAOInstance();
		loginAttemptDao.cleanupOldAttempts();
	}

}
