package com.erp.test.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	int updateEmployee(Map<String, Object> emp);
	int insertEmployee(Map<String, Object> emp);
	int deleteEmployee(Map<String, Object> emp);
	Map<String, Object> selectEmployee(Map<String, Object> emp);
	List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp);
	
}
