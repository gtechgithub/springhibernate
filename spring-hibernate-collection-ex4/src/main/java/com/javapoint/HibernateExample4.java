package com.javapoint;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateExample4 {

	public static void main(String args[]) {

		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
		EmployeeService service = (EmployeeService)context.getBean("employeeservice");
		
		//add operation
		ArrayList certificate1= new ArrayList();
		certificate1.add(new Certificate("BCA"));
		certificate1.add(new Certificate("MBA"));

		service.addEmployee("first name1", "last name1", 1000,certificate1);
		
		
		ArrayList certificate2=new ArrayList();
		certificate2.add(new Certificate("MBBS"));
		certificate2.add(new Certificate("MD"));
		service.addEmployee("first name2", "last name2", 2000,certificate2);

		ArrayList certificate3=new ArrayList();
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
		}
		
	}
}


/*************OUTPUT**********************************

mysql> select  * from employee; select * from certificate;
+----+-------------+------------+--------+
| id | first_name  | last_name  | salary |
+----+-------------+------------+--------+
|  1 | first name1 | last name1 |   5000 |
|  3 | first name3 | last name3 |   3000 |
+----+-------------+------------+--------+
2 rows in set (0.00 sec)

+----+------------------+-------------+
| id | certificate_name | employee_id |
+----+------------------+-------------+
|  1 | BCA              |           1 |
|  2 | MBA              |           1 |
|  5 | BA               |           3 |
|  6 | MA               |           3 |
+----+------------------+-------------+
4 rows in set (0.00 sec)



employee:id:1 firstname:first name1 lastname:last name1 salary:5000
 Certifcates:[
 certificate id:1 certificate name:BCA, 
 certificate id:2 certificate name:MBA]
employee:id:3 firstname:first name3 lastname:last name3 salary:3000
 Certifcates:[
 certificate id:5 certificate name:BA, 
 certificate id:6 certificate name:MA]


*******************************************/