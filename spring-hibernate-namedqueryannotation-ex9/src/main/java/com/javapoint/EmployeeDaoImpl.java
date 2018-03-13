package com.javapoint;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
	public Employee findemployeeByID(int id) {
		Session session = sessionFactory.openSession() ;
		Transaction transaction = null;
		Employee emp = null;
		try {
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery("findEmployeeById");
		query.setInteger("id", id);
		emp = (Employee) query.list().get(0);
		
		transaction.commit();
		return emp;
		}
		catch (Exception e ) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
		
		return emp;
		
	}
}

	