package com.sapphire.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {
	
	public void addEmployee(Employee employee) {
		SessionFactory sessionfactory=SingletonSessionFactory.getSessionFactory();
		Transaction transaction=null;
		try{
			
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			
			session.save(employee);
			transaction.commit();
			session.close();
		}
		
		catch(HibernateException e){
			transaction.rollback(); 
		}
	
	}
	
	public void updateEmployee(Employee employee){
		SessionFactory sessionfactory=SingletonSessionFactory.getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.update(employee);
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
		}
	}
	
	public void deleteEmployee(Employee employee){
		SessionFactory sessionfactory=SingletonSessionFactory.getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
		}
	}
		
	public void getEmployeeById(Employee employee){
		SessionFactory sessionfactory=SingletonSessionFactory.getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("From Employee where empId=:id");
			query.setParameter("id", employee.getEmpId());
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
		}
	}
	
	public void getAllEmployee(){
		SessionFactory sessionfactory=SingletonSessionFactory.getSessionFactory();
		Transaction transaction=null;
	
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			List<Employee> allEmployee=new ArrayList<Employee>();
			allEmployee=session.createQuery("From Employee").list();
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
		}
	}
}