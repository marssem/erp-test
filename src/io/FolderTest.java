package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FolderTest {
	

    	public static void main(String[] args) {
    		AddressTest at = new AddressTest();
    		File path = new File("C:\\java_study\\address");
    		if(path.isDirectory()) {
    			File[] files = path.listFiles();	
    			for(File file:files) {
    				if(!file.isDirectory() && file.getName().indexOf("build_")==0) {
    					int cnt = at.insertAddress(file);
    					System.out.println(file.getName() + ", 입력갯수 : " + cnt);
    				}
    			}
    		}
    	}
}
