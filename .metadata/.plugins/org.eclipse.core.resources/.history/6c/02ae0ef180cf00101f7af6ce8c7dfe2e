package com.auth.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.auth.Model.User;
import com.auth.util.HibernateUtil;


public class UserDaoImpl implements UserDao
{

	@Override
	public Integer saveUser(User user) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=null;
		Transaction transaction=null;
		
		try
		{
			session=sessionFactory.openSession();
			transaction= session.beginTransaction();
			
			session.persist(user);
			Integer id=(Integer) session.getIdentifier(user);
			
			transaction.commit();
			
			return id;
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		
	}

	@Override
	public User findByEmail(String email) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=null;
		
		try
		{
			session=sessionFactory.openSession();
			
			String hql="FROM User WHERE email=:email";
			Query<User> query=session.createQuery(hql,User.class);
			query.setParameter("email", email);
			
			return query.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}

	}

	@Override
	public void updateUser(User user) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=null;
		Transaction transaction=null;
		
		try
		{
			session=sessionFactory.openSession();
			transaction= session.beginTransaction();
			
			session.merge(user);
			
			transaction.commit();
			
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		
	}

	@Override
	public User findById(Integer id) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=null;
		
		try
		{
			session=sessionFactory.openSession();
			
			String hql="FROM User WHERE id=:id";
			Query<User> query=session.createQuery(hql,User.class);
			query.setParameter("id", id);
			
			return query.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
	}
	
	@Override
	public void updatePassword(int userId, String hashedPassword) 
	{
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = null;
	    Transaction tx = null;

	    try {
	        session = sessionFactory.openSession();
	        tx = session.beginTransaction();

	        User user = session.get(User.class, userId); // fully initialized
	        user.setPassword(hashedPassword);
	        session.merge(user);

	        tx.commit();
	    }
	    catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }
	    finally {
	        if (session != null) session.close();
	    }
	}


}
