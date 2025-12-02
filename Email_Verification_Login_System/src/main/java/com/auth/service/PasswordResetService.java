package com.auth.service;

import com.auth.Model.PasswordReset;
import com.auth.Model.User;

public interface PasswordResetService 
{
	public void save(PasswordReset passwordReset);
	public PasswordReset findByToken(String token);
	public void delete(PasswordReset passwordReset);
	public void deleteByUser(User user);
	public void cleanupExpiredTokens() ;
	public String getEmailByToken(String token); 


}
