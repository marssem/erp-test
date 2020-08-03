package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;


public class AddressTest {
	public int insertAddress(File f) {
		String keyStr = "DONG_CODE\r\n" + "SIDO\r\n" + "GUGUN\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n" + "IS_MNT\r\n"
				+ "JIBUN\r\n" + "SUB_JIBUN\r\n" + "ROAD_CODE\r\n" + "ROAD_NAME\r\n" + "IS_BASE\r\n" + "BUILD_NUM\r\n"
				+ "SUB_BUILD_NUM\r\n" + "BUILDING_NAME\r\n" + "DETAIL_BUILDING_NAME\r\n" + "ADDR_CODE";
		String keys[] = keyStr.split("\r\n");

		try {
			System.out.println("프로그램 시작");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "MS949"));
			List<Map<String, String>> list = new ArrayList<>();
			String str;
			
			while ((str = br.readLine()) != null) {
				String[] values = str.split("\\|");
				Map<String, String> map = new HashMap<>();
				for (int j = 0; j < keys.length; j++) {
					map.put(keys[j], values[j]);
				}
				list.add(map);
			}
			long sTime = System.currentTimeMillis();
			String sql = "insert into address (";
			String value = " values(";
			for(String key:keys) {
				sql += key + ",";
				value += "?,";
			}
			sql = sql.substring(0,sql.length()-1) + ")\r\n";
			value = value.substring(0,value.length()-1) + ")";
			sql += value;
			Connection con = Conn.open();
			PreparedStatement ps = con.prepareStatement(sql);
			int cnt = 1;
			for(Map<String,String> row:list) {
				for(int i=0;i<keys.length;i++) {
					ps.setString((i+1), row.get(keys[i]));
				}
				ps.addBatch();
				if(cnt%1000==0) {
					ps.executeBatch();
					ps.clearBatch();
				}
				cnt++;
			}
			if(list.size()%1000!=0) {
				ps.executeBatch();
				ps.clearBatch();
			}
			con.commit();
			long eTime = System.currentTimeMillis();
			System.out.println("실행시간 : " + (eTime-sTime));
			return list.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		AddressTest at = new AddressTest();
		String s = "C:\\java_study\\address";
		File path = new File("C:\\java_study\\address");
		if(path.isDirectory()) {
			File[] files = path.listFiles();	
			for(File file:files) {
				if(!file.isDirectory() && file.getName().indexOf("build_sejong")==0) {
					int cnt = at.insertAddress(file);
					s += file.getName();
					System.out.println(file.getName() + ", 입력갯수 : " + cnt);
				}
			}
		}
		
		
 		File f = new File(s);
		at.insertAddress(f);
	}
}


