package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Demo1Test {
	
	@Test
	public void sum(){
		System.out.println("Sum");
		int a = 10;
		int b = 20;
		AssertJUnit.assertEquals(30, a+b);
		
	}
	
	@Test
	public void sub(){
		int a = 10;
		int b = 20;
		AssertJUnit.assertEquals(10, b-a);
		System.out.println("Sub");
	}
	
	@Test
	public void mul(){
		int a = 10;
		int b = 20;
		AssertJUnit.assertEquals(200, a*b);
		System.out.println("Mul");
	}
	
	@Test
	public void div(){
		int a = 10;
		int b = 20;
		AssertJUnit.assertEquals(2, b/a);
		System.out.println("Div");
	}
}
