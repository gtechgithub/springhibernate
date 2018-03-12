package com.javapoint;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample2 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		EmployeeService service = (EmployeeService)context.getBean("employeeservice");
		
		//add operation
		HashSet certificate1= new HashSet();
		certificate1.add(new Certificate("BCA"));
		certificate1.add(new Certificate("MBA"));

		service.addEmployee("first name1", "last name1", 1000,certificate1);
		
		
		HashSet certificate2=new HashSet();
		certificate2.add(new Certificate("MBBS"));
		certificate2.add(new Certificate("MD"));
		service.addEmployee("first name2", "last name2", 2000,certificate2);

		HashSet certificate3=new HashSet();
		certificate3.add(new Certificate("BA"));
		certificate3.add(new Certificate("MA"));

		service.addEmployee("first name3", "last name3", 3000,certificate3);
		
		//get 2nd employee
		System.out.println("employee:" + service.listEmployee(2));
		
		//update operation
		service.updateEmployee(1, 5000);

		//get 2nd employee
		System.out.println("employee:" + service.listEmployee(2));
		
		//delete operation
		service.deleteEmployee(2);
		
		//getall operation
		for(Employee emp: service.listAllEmployees()) {
			System.out.println("employee:" + emp);
			/*
			Set certificate5 =  emp.getCertificates();
			
			for (Iterator iter=certificate5.iterator(); iter.hasNext();) {
				
				System.out.println("certificate" + ((Certificate) iter.next()).getCertificateName());
			}
			*/
		}
		
	}
}


/*************OUTPUT**********************************





employee:id:1 firstname:first name1 lastname:last name1 salary:5000
Certifcates:[
certificate id:1 certificate name:BCA, 
certificate id:2 certificate name:MBA]
employee:id:3 firstname:first name3 lastname:last name3 salary:3000
Certifcates:[
certificate id:6 certificate name:MA, 
certificate id:5 certificate name:BA]

*******************************************/