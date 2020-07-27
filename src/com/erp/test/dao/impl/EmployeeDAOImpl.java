package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;
import com.erp.test.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int updateEmployee(Map<String, Object> emp) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int result = 0;
		 try {
			 con = Conn.open();
			 String sql = "update employee set emp_name=?, emp_salary=?, grd_no=?, where emp_no=?";
			 ps = con.prepareStatement(sql);
			 ps.setObject(1, emp.get("emp_name"));
			 ps.setObject(2, emp.get("emp_salary"));
			 ps.setObject(3, emp.get("grd_no"));
			 ps.setObject(4, emp.get("emp_no"));
			 result = ps.executeUpdate();
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return result;
	}

	@Override
	public int insertEmployee(Map<String, Object> emp) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int result = 0;
		 try {
			 con = Conn.open();
			 String sql = "insert into employee(emp_no, emp_name, emp_salary, grd_no, emp_credat) "
			 		+ "values(seq_employee_emp_no.nextval, ?, ?, ?, sysdate)";
			 ps = con.prepareStatement(sql);
			 ps.setObject(1, emp.get("emp_name"));
			 ps.setObject(2, emp.get("emp_salary"));
			 ps.setObject(3, emp.get("grd_no"));
			
			 result = ps.executeUpdate();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return result;
	}

	@Override
	public int deleteEmployee(Map<String, Object> emp) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int result = 0;
		 try {
			 con = Conn.open();
			 String sql = "update employee "
			 		+ " set emp_active=0"
			 		+ " where emp_no=?";
			 ps = con.prepareStatement(sql);
			 ps.setObject(1, emp.get("emp_no"));
			 result = ps.executeUpdate();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return result;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> emp) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 con = Conn.open();
			 String sql = "select emp_no, emp_name, emp_salary, grd_no, emp_active, emp_credat "
			 		+ "from employee where emp_no=? ";
			 ps = con.prepareStatement(sql);
			 ps.setObject(1, emp.get("emp_no"));
			 rs = ps.executeQuery();
			 Map<String, Object> rMap = new HashMap<>();
			if(rs.next()) {
				rMap.put("emp_name", rs.getObject("emp_name"));
				rMap.put("emp_salary", rs.getObject("emp_salary"));
				rMap.put("grd_no", rs.getObject("grd_no"));
				rMap.put("emp_active", rs.getObject("emp_active"));
				rMap.put("emp_credat", rs.getObject("emp_credat"));
				rMap.put("emp_no", rs.getObject("emp_no"));
				return rMap;
			}
			
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		return null;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> emp) {
		List<Map<String, Object>> empList = new ArrayList<>();
		Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			 con = Conn.open();
			String sql = "select e.emp_no, e.emp_name, e.emp_credat, e.emp_salary,(g.grd_name)"
					+ " from employee e, grade g where g.grd_no = e.grd_no";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> rMap = new HashMap<>();
				rMap.put("emp_no", rs.getObject("emp_no"));
				rMap.put("emp_name", rs.getObject("emp_name"));
				rMap.put("emp_credat", rs.getObject("emp_credat"));
				rMap.put("emp_salary", rs.getObject("emp_salary"));
				rMap.put("grd_name", rs.getObject("grd_name"));
				empList.add(rMap);
			}
			return empList;
	 } catch(SQLException e) {
		 e.printStackTrace();
	 }
	return null;
	}
public static void main(String[] args) {
	EmployeeDAO emp = new EmployeeDAOImpl();
	Map<String, Object> map = new HashMap<>();
	map.put("emp_name", "test");
	map.put("emp_salary", "9876");
	map.put("grd_no", "2");
	map.put("emp_active", 1);
	map.put("emp_no", 202);
	System.out.println(emp.selectEmployee(map));
}
}
