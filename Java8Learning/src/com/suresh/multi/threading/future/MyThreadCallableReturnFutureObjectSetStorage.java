package com.suresh.multi.threading.future;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyThreadCallableReturnFutureObjectSetStorage {

	public static void main(String[] args){
		
		System.out.println("MyThreadCallableReturnFutureObject main thread starts");
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Set<Future<Integer>> futureSet = new HashSet<Future<Integer>>();
		
		String[] words = {"Suresh", "Suba", "Sanjana", "Singapore"};
		
		for(String word : words){
			MyCallableTask2 callable = new MyCallableTask2(word);
			System.out.println("word length executor service submit callable method ");
			Future<Integer> future = executorService.submit(callable);
			System.out.println("Thread pools returns future object immediatle, Since submitting callable task, future object is not null.");
			System.out.println("Future object returned by thread pool: " + future);
			System.out.println("Future object returned by the submit() method is also an instance of FutureTask");
			futureSet.add(future);
		}
		
		int stringLength = 0;
		for(Future<Integer> future : futureSet){
			System.out.println("future object get method ");
			try {
				stringLength = stringLength + future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Total string lenthg: " + stringLength);
			
		executorService.shutdown();
	}
}


class MyCallableTask2 implements Callable<Integer> {
	
	String word;
	
	public MyCallableTask2(String word){
		this.word = word;
	}
	
	public Integer call() throws InterruptedException{
		System.out.println("Callable call method");
		System.out.println("sleeping for 10 sec");
		Thread.sleep(10000);
		return this.word.length();
	}
	
}