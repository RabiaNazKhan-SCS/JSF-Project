package com.sapphire.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SingletonSessionFactory {
	
	static SessionFactory sessionfactory=null;
		
	public static SessionFactory getSessionFactory(){
		if(sessionfactory==null){
			sessionfactory=new AnnotationConfiguration().configure().buildSessionFactory();
		}
		return sessionfactory;
		
		}
}	
