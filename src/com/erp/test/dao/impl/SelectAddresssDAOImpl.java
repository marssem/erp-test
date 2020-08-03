package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Conn;
import com.erp.test.dao.SelectAddressDAO;

public class SelectAddresssDAOImpl implements SelectAddressDAO {
	
	
	@Override
	public List<String> selectSidoList(String sido) {
		List<String> sidoList = new ArrayList<>();
		Connection con = Conn.open();
		String sql = "select distinct sido from select_address order by sido";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sidoList.add(rs.getString("sido"));
				//sidoList.add(rs.getString(1)); 나오는 컬럼이 하나이기에 가능하다. 2개면 ..
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sidoList;
	}

	@Override
	public List<String> selectGugunList(String sido) {
		List<String> gugunList = new ArrayList<>();
		Connection con = Conn.open();
		String sql = "select distinct gugun from select_address where sido = ? order by gugun";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sido);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				gugunList.add(rs.getString("gugun"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gugunList;
	}

	@Override
	public List<String> selectDongList(String sido, String gugun) {
		List<String> donglist = new ArrayList<>();
		Connection con = Conn.open();
		String sql = "select distinct dong_name from (select * from select_address ";
			sql	+= "where gugun=? ) where sido=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sido);
			ps.setString(2, gugun);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				donglist.add(rs.getString("dong_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return donglist;
		
	}
	public static void main(String[] args) {
		SelectAddressDAO saDao = new SelectAddresssDAOImpl();
		System.out.println(saDao.selectDongList("강남구","서울특별시"));
	}
}
