package com.erp.test.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LIstMapTest {
	public static void main(String[] args) {
		List<Map<String,String>> personList = new ArrayList<>();
		Map<String, String> person = new HashMap<>();
		person.put("name", "동동이");
		person.put("지역", "서울");
		person.put("전번", "444-01234");
		personList.add(person);
		person = new HashMap<>();
		person.put("name", "나비");
		person.put("지역", "경기");
		person.put("전번", "123-01234");
		personList.add(person);
		person = new HashMap<>();
		person.put("name", "춘삼이");
		person.put("지역", "대구");
		person.put("전번", "555-01234");
		personList.add(person);
		
		List<Map<String,String>> phoneList = new ArrayList<>();
		Map<String, String> phone = new HashMap<>();
		phone.put("지역", "서울");
		phone.put("국번", "02");
		phoneList.add(phone);
		phone = new HashMap<>();
		phone.put("지역", "부산");
		phone.put("국번", "051");
		phoneList.add(phone);
		phone = new HashMap<>();
		phone.put("지역", "대구");
		phone.put("국번", "053");
		phoneList.add(phone);
		phone = new HashMap<>();
		phone.put("지역", "인천");
		phone.put("국번", "032");
		phoneList.add(phone);
		phone = new HashMap<>();
		phone.put("지역", "경기");
		phone.put("국번", "031");
		phoneList.add(phone);
		
		/*
		 * for(Map<String,String> p:personList) { System.out.print("지역:" +
		 * p.get("지역")+" 이름:"+p.get("name")); for(Map<String,String> ph:phoneList) {
		 * if(p.get("지역").equals(ph.get("지역"))) {
		 * System.out.println("  번호 : "+ph.get("국번")+"-"+p.get("전번")); }
		 * 
		 * } }
		 */
		for(Map<String, String> p:personList) {
			for(Map<String,String> ph:personList) {
				if(p.get("지역").equals(ph.get("지역"))) {
					p.put("전번", ph.get("국번")+ "-"+ p.get("전번"));
				}
			}
			System.out.println(p);
		}
	}
}
