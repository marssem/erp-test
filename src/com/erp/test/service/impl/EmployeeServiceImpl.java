package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO empDAO = new EmployeeDAOImpl();
	@Override
	public Map<String, Object> insertEmployee(Map<String, Object> emp) {
	 Map<String, Object> eml = new HashMap<>();
	 int r = empDAO.insertEmployee(emp);
	 eml.put("msg", r==1?"입사 완료":"입사 실패");
		return eml;
	}

	@Override
	public Map<String, Object> updateEmployee(Map<String, Object> emp) {
		 Map<String, Object> eml = new HashMap<>();
		 eml.put("msg", empDAO.updateEmployee(emp)==1?"갱신 완료":"갱신 실패");
			return eml;
	}

	@Override
	public Map<String, Object> deleteEmployee(Map<String, Object> emp) {
		 Map<String, Object> eml = new HashMap<>();
		 eml.put("msg", empDAO.updateEmployee(emp)==1?"퇴사 완료":"퇴사 실패");
			return eml;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> emp) {
		return empDAO.selectEmployee(emp);
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp) {
		return empDAO.selectEmployeeList(emp);
	}
public static void main(String[] args) {
	EmployeeService e = new EmployeeServiceImpl();
	Map<String, Object> m = new HashMap<>();
	m.put("emp_no", 202);
	Map<String, Object> map = new HashMap<>();
	map.put("emp_name", "test");
	map.put("emp_salary", "9876");
	map.put("grd_no", "2");
	map.put("emp_active", 1);
	System.out.println(e.insertEmployee(map));
}
}
