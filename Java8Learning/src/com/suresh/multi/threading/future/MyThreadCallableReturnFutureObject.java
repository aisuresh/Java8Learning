package com.suresh.multi.threading.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyThreadCallableReturnFutureObject {

	public static void main(String[] args){
		
		System.out.println("MyThreadCallableReturnFutureObject main thread starts");
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		// FutureTask is an implementation class of Future Interface
		System.out.println("FutureTask is an implementation class of Future Interface");
		
		FutureTask<Integer> stringLength1 = (FutureTask<Integer>) executorService.submit(new MyCallableTask("Suresh"));
		System.out.println("string lenthg 1 executor service submit callable method ");
		
		FutureTask<Integer> stringLength2 = (FutureTask<Integer>) executorService.submit(new MyCallableTask("Suba"));
		System.out.println("string lenthg 2 executor service submit callable method ");
		
		FutureTask<Integer> stringLength3 = (FutureTask<Integer>) executorService.submit(new MyCallableTask("Sanjana"));
		System.out.println("string lenthg 3 executor service submit callable method ");
		
		FutureTask<Integer> stringLength4 = (FutureTask<Integer>) executorService.submit(new MyCallableTask("Singapore"));
		System.out.println("string lenthg 4 executor service submit callable method ");
				
		int stringWordLength = 0;
		try {
			System.out.println("string lenthg 1 future task -> future object get method ");
			stringWordLength = stringLength1.get();
			System.out.println("string lenthg 1 future object get method  completed");
			
			System.out.println("string lenthg 2 future task -> future object get method ");
			stringWordLength = stringWordLength + stringLength2.get();
			System.out.println("string lenthg 2 future object get method  completed");
			
			System.out.println("string lenthg 3 future task -> future object get method ");
			stringWordLength = stringWordLength + stringLength3.get();
			System.out.println("string lenthg 3 future object get method  completed");
			
			System.out.println("string lenthg 4 future task -> future object get method ");
			stringWordLength = stringWordLength + stringLength4.get();
			System.out.println("string lenthg 4 future object get method completed");
			
			System.out.println("Total string lenthg: " + stringWordLength);
			
			executorService.shutdown();
			
			System.out.println("Shutting down executorSerive..");
			
		} catch (InterruptedException | ExecutionException e) {			
			e.printStackTrace();
		}		
	}
}


class MyCallableTask implements Callable<Integer> {
	
	String word;
	
	public MyCallableTask(String word){
		this.word = word;
	}
	
	public Integer call() throws InterruptedException{
		System.out.println("Callable call method");
		System.out.println("sleeping for 10 sec");
		Thread.sleep(10000);
		return this.word.length();
	}
	
}