package com.javapoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	private Configuration cfg;
	private SessionFactory sessionFactory;
	

	EmployeeDaoImpl(){
		//configure configuration
		cfg = new Configuration();
		cfg.configure("Employee.cfg.xml");
		
		//configure session factory
		sessionFactory = cfg.buildSessionFactory();
	}
	
	
	@Override
	public void addEmployee(String firstName, String lastName, int salary, Map certificates) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Employee emp = new Employee(firstName,lastName,salary);
			emp.setCertificates(certificates);
			session.persist(emp);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void updateEmployee(int empId, int salary) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Employee emp = listEmployee(empId);
			emp.setSalary(salary);
			session.update(emp);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}

	}

	@Override
	public Employee listEmployee(int empId) {
		Employee emp = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Employee where id=:empId");
			query.setParameter("empId",empId);
			List<Employee> employeeList= query.getResultList();
			emp =  employeeList.get(0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return emp;
	}

	@Override
	public List<Employee> listAllEmployees(){
		List<Employee> employeeList =  null;

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Employee");
			employeeList = query.getResultList();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return employeeList;	
}

	@Override
	public void deleteEmployee(int empId) {

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			Employee emp =  new Employee();
			emp  = listEmployee(empId);
			session.delete(emp);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}
}
