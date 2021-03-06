package com.javapoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public void addEmployee(String firstName, String lastName, int salary) {
		employeeDao.addEmployee(firstName, lastName, salary);
	}

	public void updateEmployee(int empId, int salary) {
		employeeDao.updateEmployee(empId, salary);
	}
	
	public Employee listEmployee(int empId) {
		return employeeDao.listEmployee(empId);
	}
	
	public List<Employee> listAllEmployees(){
		return employeeDao.listAllEmployees();
	}
	
	public void deleteEmployee(int empId) {
		employeeDao.deleteEmployee(empId);
	}
}
