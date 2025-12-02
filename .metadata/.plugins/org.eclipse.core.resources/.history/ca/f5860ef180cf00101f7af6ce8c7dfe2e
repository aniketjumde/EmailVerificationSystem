package com.auth.dao;

import com.auth.Model.LoginAttempt;

public interface LoginAttemptDAO 
{
	public LoginAttempt findByEmail(String email);
	public void saveOrUpdate(LoginAttempt attempt);
	public void resetAttempts(String email);
	public void cleanupOldAttempts();
	
	
}
