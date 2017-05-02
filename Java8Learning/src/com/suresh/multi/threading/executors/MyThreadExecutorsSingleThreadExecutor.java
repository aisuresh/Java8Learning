package com.suresh.multi.threading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadExecutorsSingleThreadExecutor {

	public static void main(String[] args) {
		
		System.out.println("main thread starts");
		
		// for synchronization process - 1 task at a time.
		// Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time. 
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.submit(new SingleThreadTask());
		executorService.submit(new SingleThreadTask());
		executorService.submit(new SingleThreadTask());
		
		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isTerminated " + executorService.isShutdown());

		executorService.submit(new SingleThreadTask());
		
		executorService.shutdown();

		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isShutdown " + executorService.isShutdown());
		
		// executorService.submit(new SingleThreadTask()); // after executorService shutdown, submitting task(thead instance) will throw RejectedExecution Exception
		
		System.out.println("main thread ends");
	}
}

class SingleThreadTask extends Thread {

	@Override
	public void run() {
		System.out.println("Thread starting - " + this.getName());
		
		try{
			for(int i=1; i<=5; i++){
				System.out.println("task " + i + " from " + this.getName());
				Thread.sleep(1000);
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Thread ending - " + this.getName());
	}	
}
