package com.javapoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample11 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		EmployeeService service = (EmployeeService)context.getBean("employeeservice");

		System.out.println (service.findemployeeByID(2));
		
		System.out.println (service.findemployeeByID(2));
		
		
	}

}
/*************OUTPUT**********************************

mysql> select * from employee;
+----+-------------+------------+--------+
| id | first_name  | last_name  | salary |
+----+-------------+------------+--------+
|  1 | first name1 | last name1 |   1000 |
|  2 | first name2 | last name2 |   2000 |
|  3 | first name3 | last name3 |   3000 |
+----+-------------+------------+--------+
3 rows in set (0.00 sec)



id:2 firstname:first name2 lastname:last name2 salary:2000



******************************************************/