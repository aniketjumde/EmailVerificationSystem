package com.auth.service;

import com.auth.Model.LoginAttempt;

public interface LoginAttemptService 
{
	public LoginAttempt findByEmail(String email);
	public void saveOrUpdate(LoginAttempt attempt);
	public void resetAttempts(String email);
	public void cleanupOldAttempts();

}
