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
import com.erp.test.dao.GradeDAO;

public class GradeDAOImpl implements GradeDAO {
	
	@Override
	public int insertGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "insert into grade(grd_no, grd_name, grd_desc)";
			sql += " values((select max(grd_no)+1 from grade), ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(2, grade.get("grd_name").toString());
			ps.setString(3, grade.get("grd_desc").toString());
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return result;
	}

	@Override
	public int updateGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "update grade ";
			sql += " set grd_name=?, grd_desc=? where grd_no=? ";
			ps = con.prepareStatement(sql);
			ps.setObject(1, grade.get("grd_name"));
			ps.setObject(2, grade.get("grd_desc"));
			ps.setObject(3, grade.get("grd_no"));
			result =  ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int deleteGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "delete from grade where grd_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, grade.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conn.open();
			String sql = "select * from grade ";
			sql += "where grd_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, grade.get("grd_no"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String, Object> s = new HashMap<>();
				s.put("grd_no", rs.getInt("grd_no"));
				s.put("grd_name",  rs.getString("grd_name"));
				s.put("grd_desc",  rs.getString("grd_desc"));
				return s;
			}
				
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,Object>> gradeList = new ArrayList<>();
		try {
			con = Conn.open();
			String sql = "select * from grade ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> rMap = new HashMap<>();
				rMap.put("grd_no", rs.getInt("grd_no"));
				rMap.put("grd_name",  rs.getString("grd_name"));
				rMap.put("grd_desc",  rs.getString("grd_desc"));
				gradeList.add(rMap);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return gradeList;
		}
public static void main(String[] args) {
	GradeDAO g = new GradeDAOImpl();
	Map<String, Object> grade = new HashMap<>();
	
	
}
}
