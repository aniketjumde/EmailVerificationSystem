package com.auth.service;

import com.auth.Factory.PasswordResetDaoFactory;
import com.auth.Model.PasswordReset;
import com.auth.Model.User;
import com.auth.dao.PasswordResetDAO;

public class PasswordResetServiceImpl implements PasswordResetService 
{

	@Override
	public void save(PasswordReset passwordReset) 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();
		passwordResetDao.save(passwordReset);
	}

	@Override
	public PasswordReset findByToken(String token) 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();

		return passwordResetDao.findByToken(token);
	}

	@Override
	public void delete(PasswordReset passwordReset) 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();
		
		passwordResetDao.delete(passwordReset);
		
	}

	@Override
	public void deleteByUser(User user) 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();
		
		passwordResetDao.deleteByUser(user);
	}

	@Override
	public void cleanupExpiredTokens() 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();
		
		passwordResetDao.cleanupExpiredTokens();
	}

	@Override
	public String getEmailByToken(String token) 
	{
		PasswordResetDAO passwordResetDao=PasswordResetDaoFactory.getPasswordResetDAOInstance();

		return passwordResetDao.getEmailByToken(token);
	}

}
