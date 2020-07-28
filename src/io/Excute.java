package io;

import java.util.List;
import java.util.Map;

public class Excute {
	public static void main(String[] args) {
		String str = ReadText.readText("c:\\read.txt");
		List<Map<String,String>> phList = ReadText.parse(str);
		System.out.println(phList);
	}
}
