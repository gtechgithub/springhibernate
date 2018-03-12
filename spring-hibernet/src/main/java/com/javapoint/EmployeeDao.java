package com.javapoint;

import java.util.List;

public interface EmployeeDao {

	public void addEmployee(String firstName, String lastName, int salary);

	public void updateEmployee(int empId, int salary);
	
	public Employee listEmployee(int empId);
	
	public List<Employee> listAllEmployees();
	
	public void deleteEmployee(int empId);
}
