package com.javapoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample7 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		EmployeeService service = (EmployeeService)context.getBean("employeeservice");
		
		//add operation
		service.addEmployee("first name1", "last name1", 1000);
		service.addEmployee("first name2", "last name2", 2000);
		service.addEmployee("first name3", "last name3", 3000);
		
		for (Iterator iterator = service.listAllEmployees().iterator(); iterator.hasNext();){
            Object[] employee = (Object[]) iterator.next(); 
            System.out.println("First Name: " + employee[0]); 
            System.out.println("salary: " + employee[1]); 
         }
	}
}


/*************OUTPUT**********************************


mysql> select  * from employee; select * from certificate;
+----+-------------+------------+--------+
| id | first_name  | last_name  | salary |
+----+-------------+------------+--------+
|  1 | first name1 | last name1 |   1000 |
|  2 | first name2 | last name2 |   2000 |
|  3 | first name3 | last name3 |   3000 |
+----+-------------+------------+--------+
3 rows in set (0.00 sec)

Empty set (0.00 sec)

First Name: first name3
salary: 3000


******************************************************/