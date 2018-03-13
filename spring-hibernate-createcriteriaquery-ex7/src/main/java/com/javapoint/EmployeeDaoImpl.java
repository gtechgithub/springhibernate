package com.javapoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.type.Type;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	public void addEmployee(String firstName, String lastName, int salary) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Employee emp = new Employee(firstName,lastName,salary);
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

	
	/*** extract employee salary more than 3000 and having highest degree 
	
	sql> select  * from employee; select * from certificatetypes;
	+----+-------------+------------+--------+
	| id | first_name  | last_name  | salary |
	+----+-------------+------------+--------+
	|  1 | first name1 | last name1 |   5000 |
	|  3 | first name3 | last name3 |   3000 |
	+----+-------------+------------+--------+
	2 rows in set (0.00 sec)

	+----+------------------+------------------+-------------+
	| id | certificate_type | certificate_name | employee_id |
	+----+------------------+------------------+-------------+
	|  1 | bacherlor degree | BCA              |           1 |
	|  2 | master degree    | MBA              |           1 |
	|  5 | bacherlor degree | BA               |           3 |
	|  6 | master degree    | MA               |           3 |
	+----+------------------+------------------+-------------+
	4 rows in set (0.00 sec)

	mysql> select first_name, salary, certificate_type, certificate_name from employee emp inner join certificatetypes cert on emp.id = cert.employee_id where emp.salary> 3000 and cert.certificate_type like '%master%'
	    -> ;
	+-------------+--------+------------------+------------------+
	| first_name  | salary | certificate_type | certificate_name |
	+-------------+--------+------------------+------------------+
	| first name1 |   5000 | master degree    | MBA              |
	+-------------+--------+------------------+------------------+
	1 row in set (0.00 sec)
	
	**********************/
	
	@Override
	public List<Employee> listAllEmployees(){
		List<Employee> employeeList =  null;

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();

			Criteria empCriteria = session.createCriteria(Employee.class);

			ProjectionList properties = Projections.projectionList();
			properties.add(Projections.property("firstName"));
			properties.add(Projections.property("salary"));
			empCriteria.setProjection(properties);

			
			//properties.add(Projections.property("certificates"));
			//Criteria certCriteria = empCriteria.createCriteria("certificates");
			empCriteria.add(Restrictions.gt("salary",2000));
			
			//get the resultset
			employeeList  = empCriteria.list(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return employeeList;	
	}

}
