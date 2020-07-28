package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadText {
public static String read(String path) {
	File f = new File(path);
	FileInputStream fis;
	try {
		fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		StringBuffer sb = new StringBuffer(); 
		while((str=br.readLine())!=null) {
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
public static List<Map<String,String>> pharse(String str){
	List<Map<String,String>> list = new ArrayList<>();
	String[] keys = null;
	String[] strs = null;
	for(int i=0;i<strs.length;i++) {
		if(i==0) {
			keys = str.split("\\|");
		}else {
			
		}
	}
	return null;
}
}
