package com.auth.service;

import com.auth.Model.User;

public interface UserService 
{
	public abstract Integer saveUser(User user);
	public abstract User findByEmail(String email);
	public abstract User findById(Integer id);
	public abstract void updateUser(User user);
	public abstract boolean isEmailExists(String email);
	void updatePassword(int userId, String hashedPassword);

}
