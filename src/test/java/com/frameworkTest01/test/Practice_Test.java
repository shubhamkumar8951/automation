package com.frameworkTest01.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice_Test {
	
	public void testing() {
		System.out.println("test");
	}
	public static void main(String args[]) throws ParseException {
		String st = "Jan 03 2012";
		DateFormat orgnlFor = new SimpleDateFormat("MMM dd yyyy");
		Date dt = orgnlFor.parse(st);
		DateFormat expctd = new SimpleDateFormat("MMMM d yy");
		System.out.println(expctd.format(dt));
		
		
		
	}

}
