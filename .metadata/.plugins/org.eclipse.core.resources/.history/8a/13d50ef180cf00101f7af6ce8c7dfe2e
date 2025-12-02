package com.auth.service;

import com.auth.Factory.UserDaoFactory;
import com.auth.Model.User;
import com.auth.dao.UserDao;

public class UserServiceImpl implements UserService
{

	@Override
	public Integer saveUser(User user) 
	{
		UserDao userDao=UserDaoFactory.getUserDaoFactory();	
		
		user.setName(user.getName().toLowerCase());
		user.setEmail(user.getEmail().toLowerCase());
		
		
		return userDao.saveUser(user);
		
	}

	@Override
	public User findByEmail(String email) 
	{
		UserDao userDao=UserDaoFactory.getUserDaoFactory();	

		
		return userDao.findByEmail(email.toLowerCase());
	}

	@Override
	public void updateUser(User user) 
	{
		UserDao userDao=UserDaoFactory.getUserDaoFactory();	

		user.setName(user.getName().toLowerCase());
		user.setEmail(user.getEmail().toLowerCase());
		
		
		userDao.updateUser(user);
		
	}

	@Override
	public User findById(Integer id) 
	{
		UserDao userDao=UserDaoFactory.getUserDaoFactory();	

		return userDao.findById(id);
	}
	
	public boolean isEmailExists(String email) {
        return findByEmail(email) != null;
    }
	
	@Override
	public void updatePassword(int userId, String hashedPassword) 
	{
		UserDao userDao=UserDaoFactory.getUserDaoFactory();	
	    userDao.updatePassword(userId, hashedPassword);
	}


}
