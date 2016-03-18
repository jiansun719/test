package com.sun.domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory 
			= new Configuration()
			.configure()
			.buildSessionFactory(); 
	
	@Test
	public void testSave(){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		//try{
			Department dep = new Department();
			Employee employee1 = new Employee();
			employee1.setName("zhangsan");
			Employee employee2 = new Employee();
			employee2.setName("lisi");
			Set<Employee> employeeSet = new HashSet<Employee>();
			dep.setName("yanfabu");
			dep.setEmployeeSet(employeeSet);
			
			employeeSet.add(employee1);
			employeeSet.add(employee2);
			//employee1.setDepartment(dep);
			
			session.save(employee1);
			session.save(employee2);
			session.save(dep);
			
			tr.commit();
		//}catch(HibernateException e){
		//	tr.rollback();
		//	throw e;
		//}finally {
			session.close();
		//}
	}
	
	@Test
	public void testGet(){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
			//session.get(Department.class, 3);
			Employee emp = (Employee) session.get(Employee.class, 5);
			System.out.println(emp);
			tr.commit();
		//}catch(HibernateException e){
		//	tr.rollback();
		//	throw e;
		//}finally {
			session.close();
		//}
	}
	
	@Test
	public void testDelete(){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try{
			Department dep = (Department) session.get(Department.class, 3);
			session.delete(dep);
			tr.commit();
		}catch(HibernateException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}
	
}
