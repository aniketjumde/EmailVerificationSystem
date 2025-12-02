package com.auth.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.auth.Model.EmailVerification;
import com.auth.Model.User;
import com.auth.util.HibernateUtil;

public class EmailVerificationDAOImpl implements EmailVerificationDAO
{

	@Override
	public void save(EmailVerification verification) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		try(Session session=sessionFactory.openSession())
		{
			transaction=session.beginTransaction();
			
			session.persist(verification);
			
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	@Override
	public EmailVerification findByToken(String token) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

		try(Session session=sessionFactory.openSession())
		{
			String hql="FROM EmailVerification Where token=:token";
            Query<EmailVerification> query = session.createQuery(hql,EmailVerification.class);
            query.setParameter("token",token);
            return query.uniqueResult();

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
			}

	@Override
	public void delete(EmailVerification verification) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;


		try(Session session=sessionFactory.openSession())
		{
            transaction = session.beginTransaction();

            session.remove(verification);
            
            transaction.commit();
			
		}
		catch(Exception e)
		{
			
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByUser(User user) 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;

		try(Session session=sessionFactory.openSession())
		{

            transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM EmailVerification WHERE user = :user",EmailVerification.class);
            query.setParameter("user", user);
            query.executeUpdate();
            transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction !=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void cleanupExpiredTokens() 
	{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Transaction transaction=null;

		try(Session session=sessionFactory.openSession())
		{
			 transaction = session.beginTransaction();
	         Query<?> query = session.createQuery("DELETE FROM EmailVerification WHERE expiry < :now",EmailVerification.class);
	         query.setParameter("now", LocalDateTime.now());
	         query.executeUpdate();
	         transaction.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
