package com.javapoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public void addEmployee(String firstName, String lastName, int salary) {
		employeeDao.addEmployee(firstName, lastName, salary);
	}

	public List<Employee> listAllEmployees(){
		return employeeDao.listAllEmployees();
	}
}
