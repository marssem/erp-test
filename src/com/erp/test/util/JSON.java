package com.erp.test.util;

import com.google.gson.Gson;

public class JSON {
	private final static Gson gson = new Gson();
	public static String stringify(Object obj) {
		return gson.toJson(obj);
	}
	public static Object parse(String json) {
		return gson.fromJson(json, Object.class);
	}
}