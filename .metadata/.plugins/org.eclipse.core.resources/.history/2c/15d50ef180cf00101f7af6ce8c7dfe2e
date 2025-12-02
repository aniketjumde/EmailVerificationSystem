package com.auth.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.auth.config.HibernateConfig;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory=null;
	
	private HibernateUtil() {} ;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Configuration configuration=new Configuration();
			configuration.configure(HibernateConfig.HIBCONFIG_FILE);
			sessionFactory=configuration.buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	public static void getCloseSessionFactory()
	{
		sessionFactory.close();
	}

}
 