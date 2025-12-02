package com.auth.dao;

import com.auth.Model.User;

public interface UserDao 
{

	public abstract Integer saveUser(User user);
	public abstract User findByEmail(String email);
	public abstract User findById(Integer id);
	public abstract void updateUser(User user);
	void updatePassword(int userId, String hashedPassword);

}
