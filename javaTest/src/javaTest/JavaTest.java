package javaTest;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {
	 int a =4;
	public void JavaTest1() {
		System.out.println(this.a);
		System.out.println(a);
	}
	
	public void JavaTest1(int a) {
		System.out.println(this.a);
	}

	public int returnCheck(int a, int b) {
		System.out.println(a);
		System.out.println(b);
		return b;
	}
	
	
	public static void main(String args[]) {
		new JavaTest();
		//add("5");
	int s1 =10;
	int s2 = 10;
	System.out.println(s1==s2);
	List<String> listTest =new ArrayList<String>();
	listTest.add("1");
	listTest.add("2");
	listTest.add("3");
	
	List<String> listTest1 =new ArrayList<String>();
	//listTest.add("11");
	listTest.add("2");
	listTest.add("3");
	 
	int count=0;
	if(listTest.retainAll(listTest1))
		System.out.println("list contain");
	}
	
	

}
