package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest {
	public static void main(String[] args) {
		File f = new File("c:\\read.txt");//없는 파일도 생성을 해야 하기 때문에 read할 때 에러가 나는 것이다.
		try {
			FileReader fr =  new FileReader(f);
			int ch = fr.read();
			String str = "";
			while(ch!=-1) {
				str += (char)ch;
				ch = fr.read();
			}
			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
