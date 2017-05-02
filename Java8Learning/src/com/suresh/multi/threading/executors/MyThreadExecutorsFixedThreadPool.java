package com.suresh.multi.threading.executors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadExecutorsFixedThreadPool {

	public static void main(String[] args) {
		
		System.out.println("main thread starts");
		
		// fixed size thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Future<?> future =  executorService.submit(new FixedThreadTask());
		
		try {
			System.out.println("########## Future get() - blocking method ##########");
			future.get(); // blocking means your code in next line will not be executed
			// Executor Service submit(Runnbale) method returns null Future object.	
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("########## After Future get() method.. ##########");
		
		executorService.submit(new FixedThreadTask());
		executorService.submit(new FixedThreadTask());
		executorService.submit(new FixedThreadTask());
		
		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isTerminated " + executorService.isShutdown());
		
		//executorService.submit(new FixedThreadTask());
		
		executorService.shutdown();

		/*List<Runnable> pendingTasks = executorService.shutdownNow();
		
		if(pendingTasks != null) {
			for(Runnable r : pendingTasks) {
				System.out.println(r);
			}
		}*/
		
		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isShutdown " + executorService.isShutdown());
		
		// executorService.submit(new FixedThreadTask()); // after executorService shutdown, submitting task(thead instance) will throw RejectedExecution Exception
		
		System.out.println("main thread ends");
	}
}

class FixedThreadTask extends Thread {

	@Override
	public void run() {
		System.out.println("Thread starting - " + this.getName());
		
		try{
			for(int i=1; i<=5; i++){
				System.out.println("task " + i + " from " + this.getName());
				Thread.sleep(1000);				
			}				
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Thread ending - " + this.getName());
	}	
}
