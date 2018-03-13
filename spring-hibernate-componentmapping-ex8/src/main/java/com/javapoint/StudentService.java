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
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public void addStudent(String name, Address address) {
		studentDao.addStudent(name, address);
	}
}
