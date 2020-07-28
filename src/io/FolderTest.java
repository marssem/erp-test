package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FolderTest {
	
    public static void main(String[] args) {
		File path = new File("C:\\java_study\\address");
		System.out.println(path.isDirectory());
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			for(File file:files) {
				if(!file.isDirectory() && file.getName().indexOf("build_")==0) {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("file.getName()"))));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				
				}
			}
		}
    }
}
