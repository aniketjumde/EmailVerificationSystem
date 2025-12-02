package com.auth.dao;

import com.auth.Model.EmailVerification;
import com.auth.Model.User;

public interface EmailVerificationDAO 
{

    public void save(EmailVerification verification);
    public EmailVerification findByToken(String token);
    public void delete(EmailVerification verification);
    public void deleteByUser(User user);
    public void cleanupExpiredTokens();

}
