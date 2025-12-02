package com.auth.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.auth.Model.LoginAttempt;
import com.auth.util.HibernateUtil;

public class LoginAttemptDAOImpl implements LoginAttemptDAO 
{

	@Override
	public LoginAttempt findByEmail(String email) 
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
            Query<LoginAttempt> query = session.createQuery("FROM LoginAttempt WHERE email = :email", LoginAttempt.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void saveOrUpdate(LoginAttempt attempt) 
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.merge(attempt);
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            	transaction.rollback();
            e.printStackTrace();
        }
	}

	@Override
	public void resetAttempts(String email) 
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM LoginAttempt WHERE email = :email");
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		
	}

	@Override
	public void cleanupOldAttempts() 
	{
		 Transaction transaction = null;
	     try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	     {
	        transaction = session.beginTransaction();
	        Query<?> query = session.createQuery("DELETE FROM LoginAttempt WHERE lastAttempt < :cutoff",LoginAttempt.class);
	        query.setParameter("cutoff", LocalDateTime.now().minusHours(24));
	        query.executeUpdate();
	        transaction.commit();
	     } 
	     catch (Exception e) 
	     {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	     }
		
	}

}
