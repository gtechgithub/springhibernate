package com.javapoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample6 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		EmployeeService service = (EmployeeService)context.getBean("employeeservice");
		
		//add operation
		TreeMap certificate1= new TreeMap();
		certificate1.put("master degree",new Certificate("MBA"));
		certificate1.put("bacherlor degree", new Certificate("BCA"));

		service.addEmployee("first name1", "last name1", 1000,certificate1);
		
		
		TreeMap certificate2= new TreeMap();
		certificate2.put("master degree",new Certificate("MD"));
		certificate2.put("bacherlor degree", new Certificate("MBBS"));
		service.addEmployee("first name2", "last name2", 2000,certificate2);

		TreeMap certificate3= new TreeMap();
		certificate3.put("master degree",new Certificate("MA"));
		certificate3.put("bacherlor degree", new Certificate("BA"));

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
		}
	}
}


/*************OUTPUT**********************************

mysql> select  * from employee; select * from certificatetypes;
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


employee:id:1 firstname:first name1 lastname:last name1 salary:5000
 Certifcates:
 {master degree= certificate id:2 certificate name:MBA, 
 bacherlor degree= certificate id:1 certificate name:BCA}

employee:id:3 firstname:first name3 lastname:last name3 salary:3000
 Certifcates:
 {master degree= certificate id:6 certificate name:MA, 
 bacherlor degree=certificate id:5 certificate name:BA}


******************************************************/