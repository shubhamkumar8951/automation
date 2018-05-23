package testing;

import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class testing {
	private static boolean isPrimeNumber(int number) {

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Map<String, String> mapCountryCodes = new HashMap<>();

		mapCountryCodes.put("1", "USA");
		mapCountryCodes.put("44", "United Kingdom");
		mapCountryCodes.put("33", "France");
		mapCountryCodes.put("81", "Japan");

		
		List<String> linklis = new LinkedList<String>();
		linklis.add("abc");
		linklis.add("def");
		linklis.add("ghi");
		linklis.add("jkl");
		String st = (String)linklis.get(2);
		System.out.println(st);
		System.out.println(linklis.indexOf("ghi"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
