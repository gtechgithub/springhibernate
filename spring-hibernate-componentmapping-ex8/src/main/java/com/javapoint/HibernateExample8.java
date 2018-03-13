package com.javapoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample8 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		StudentService service = (StudentService)context.getBean("studentservice");
		
		//add operation
		Address address = new Address("street1","city1","state1","zipcode1");
		service.addStudent("name1", address); 
		
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