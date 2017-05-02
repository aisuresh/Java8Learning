package com.suresh.generic;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class GenericParametrizedClass {

	public static void main(String[] args){
		Wrapper<String> wrapperString = new Wrapper<String>();
		
		wrapperString.setItem("string item");
		
		System.out.println(wrapperString.getItem());
		
		Wrapper<Integer> wrapperInteger = new Wrapper<>(); // diamond operator since jdk 7
		
		wrapperInteger.setItem(123);
		
		System.out.println(wrapperInteger.getItem());
	
		// call parameterized method or generic method 
		String tasks = wrapperString.getItems("Task");
	
		System.out.println(tasks);
		
		Integer tasks2 = wrapperString.getItems(123);
		
		System.out.println(tasks2);
		
		List<String> stooges = new ArrayList<String>();
		
		stooges.add("Suresh");
		stooges.add("Suba");
		stooges.add("Sanjana");
		
		ArrayList<String> tasks3 = (ArrayList<String>) wrapperString.getItems(stooges);
		
		System.out.println(tasks3.toString());
	}
	
}

// Parameterized classes offer compile time type verification
class Wrapper<T> {
	
	private T item;
	
	public T getItem(){
		return item;
	}

	public void setItem(T t){
		this.item  = t;
	}
	
	// Parameterized method prevents duplication of code and provides type-safety at compile time
	public <T> T getItems(T task){
		return task;
	}
	
}
