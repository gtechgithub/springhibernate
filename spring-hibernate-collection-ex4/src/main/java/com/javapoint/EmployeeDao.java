package com.javapoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface EmployeeDao {

	public void addEmployee(String firstName, String lastName, int salary,Collection cerficates);

	public void updateEmployee(int empId, int salary);
	
	public Employee listEmployee(int empId);
	
	public List<Employee> listAllEmployees();
	
	public void deleteEmployee(int empId);
}
