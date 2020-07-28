package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class ReadText {
	public static String reader(String path) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String str;
			StringBuffer sb = new StringBuffer();
			while((str=br.readLine())!=null){
				sb.append(str+"|");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static List<Map<String,String>> parse(String str){
		List<Map<String,String>> list = new ArrayList<>();
		String[] strs = str.split("\\|");
		String[] keys = null;
		for(int i=0;i<strs.length;i++) {
			if(i==0) {
				keys = strs[i].split(",");
			}else {
				Map<String,String> map = new HashMap<>();
				String[] values = strs[i].split(",");
				if(keys.length==values.length) {
				for(int it=0;it<keys.length;it++) {
					map.put(keys[it], values[it]);
				}
				}
				list.add(map);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(parse(reader("c:\\read.txt")));
	}
}










