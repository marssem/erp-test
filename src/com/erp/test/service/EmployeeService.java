package com.erp.test.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

	Map<String, Object> insertEmployee(Map<String, Object> emp);
	Map<String, Object> updateEmployee(Map<String, Object> emp);
	Map<String, Object> deleteEmployee(Map<String, Object> emp);
	Map<String, Object> selectEmployee(Map<String, Object> emp);
	List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp);
}
