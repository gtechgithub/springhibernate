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
public class StudentDaoImpl implements StudentDao {

	private Configuration cfg;
	private SessionFactory sessionFactory;
	

	StudentDaoImpl(){
		//configure configuration
		cfg = new Configuration();
		cfg.configure("Student.cfg.xml");
		
		//configure session factory
		sessionFactory = cfg.buildSessionFactory();
	}
	
	
	@Override
	public void addStudent(String name, Address address) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Student emp = new Student(name,address);
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

}
