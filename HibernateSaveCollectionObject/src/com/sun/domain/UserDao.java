package com.sun.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {

	private static SessionFactory sessionFactory= new Configuration()
			//.addClass(User.class)
			.configure()
			.buildSessionFactory();
	
	
	
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			session.save(user);
			tr.commit();
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}
	
	
	public User getById(int id) {
		
		/**
		����������
		�漰����ѯʱ�ᱨ��
		lazy load����
		**/
		
		Session session = sessionFactory.openSession();
		//Transaction tr = null;
		try{
			//tr = session.beginTransaction();
			User good = (User) session.get(User.class, id);
			//tr.commit();
			return good;
		}catch(RuntimeException e){
			//tr.rollback();
			throw e;
		}finally {
			//session.close();
		}
	}

}
