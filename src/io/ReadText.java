package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadText {
	public static String readText(String path) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String str;
			while((str = br.readLine())!=null) {
				sb.append(str+"|");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public static List<Map<String,String>> parse(String str){
		String[] strs = str.split("\\|");
		String[] keys = null;
		List<Map<String,String>> list = new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			if(i==0) {
				keys = strs[i].split(",");
			}else {
				String[] values = strs[i].split(",");
				Map<String,String> map = new HashMap<>();
				if(keys.length==values.length) {
					for(int idx=0;idx<keys.length;idx++) {
						map.put(keys[idx],values[idx]);
					}
				}
			list.add(map);
			}
		
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
 * 1.텍스트를 읽는다.
 * 2.구조를 파악한다.(prase, load)
 * 3.파악된 구조를 자바에서 쉽게 사용하기 위한 구조로 병경한다.
 * 4. 받은 구조를 가지고 비지니스 로직을 수행한다.
*/	
}
