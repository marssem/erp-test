package test;

import java.util.ArrayList;
import java.util.List;

import com.erp.test.util.JSON;

public class JSONTest {

	public static void main(String[] args) {
		String numsStr = "[1,2,3]";
		List<Integer> numList = (List<Integer>) JSON.parse(numsStr);
		System.out.println(numList);
	}
}