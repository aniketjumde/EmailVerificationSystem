package com.auth.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.auth.Model.PasswordReset;
import com.auth.Model.User;
import com.auth.util.HibernateUtil;

public class PasswordResetDAOImpl implements PasswordResetDAO {

	@Override
	public void save(PasswordReset passwordReset) 
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.persist(passwordReset);
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
            	transaction.rollback();
            }
            e.printStackTrace();
        }
		
	}

	@Override
	public PasswordReset findByToken(String token) 
	{
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		 {
	        Query<PasswordReset> query = session.createQuery("FROM PasswordReset WHERE token = :token", PasswordReset.class);
	        query.setParameter("token", token);
	        return query.uniqueResult();
	     } 
		 catch (Exception e) 
		 {
	         e.printStackTrace();
	         return null;
	     }
	}

	@Override
	public void delete(PasswordReset passwordReset) 
	{
		 Transaction transaction = null;
	     try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	     {
	        transaction = session.beginTransaction();
	        session.remove(passwordReset);
	        transaction.commit();
	     } 
	     catch(Exception e) 
	     {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	     }	
	}

	@Override
	public void deleteByUser(User user) 
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM PasswordReset WHERE user = :user");
            query.setParameter("user", user);
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
	public void cleanupExpiredTokens() 
	{

		 Transaction transaction = null;
	     try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	     {
	            transaction = session.beginTransaction();
	            Query<?> query = session.createQuery("DELETE FROM PasswordReset WHERE expiry < :now");
	            query.setParameter("now", LocalDateTime.now());
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
	public String getEmailByToken(String token) 
	{
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	    {
	        return session.createQuery(
	            "select pr.user.email from PasswordReset pr where pr.token = :token",
	            String.class
	        )
	        .setParameter("token", token)
	        .uniqueResult();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        return null;
	    }
	}


}
