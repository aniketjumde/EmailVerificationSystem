package com.auth.service;

import com.auth.Factory.EmailVerificationDaoFactory;
import com.auth.Model.EmailVerification;
import com.auth.Model.User;
import com.auth.dao.EmailVerificationDAO;

public class EmailVerificationServiceImpl implements EmailVerificationService 
{

	@Override
	public void save(EmailVerification verification) 
	{
		EmailVerificationDAO emailDAO=EmailVerificationDaoFactory.getEmailVerificationDaoInstance();
		emailDAO.save(verification);
	}

	@Override
	public EmailVerification findByToken(String token) 
	{
		EmailVerificationDAO emailDAO=EmailVerificationDaoFactory.getEmailVerificationDaoInstance();
		
		return emailDAO.findByToken(token);
	}

	@Override
	public void delete(EmailVerification verification) 
	{
		EmailVerificationDAO emailDAO=EmailVerificationDaoFactory.getEmailVerificationDaoInstance();

		emailDAO.delete(verification);
		
	}

	@Override
	public void deleteByUser(User user) 
	{
		EmailVerificationDAO emailDAO=EmailVerificationDaoFactory.getEmailVerificationDaoInstance();
		
		emailDAO.deleteByUser(user);
	}

	@Override
	public void cleanupExpiredTokens() 
	{
		EmailVerificationDAO emailDAO=EmailVerificationDaoFactory.getEmailVerificationDaoInstance();
		
		emailDAO.cleanupExpiredTokens();
	}
	
}
