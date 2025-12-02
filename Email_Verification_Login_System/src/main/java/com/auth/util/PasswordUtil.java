package com.auth.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil 
{
	public static String hasPassword(String plainPassword)
	{
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));

	}
	
	public static boolean checkPassword(String plainPassword,String hashedPassword)
	{
		 try 
		 {
	            return BCrypt.checkpw(plainPassword, hashedPassword);
	     } catch (Exception e) 
		 {
	            return false;
	     }
	}
	
	public static boolean isStrongPassword(String password) 
	{
		
        if (password == null || password.length() < 8) 
        {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) 
        {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
