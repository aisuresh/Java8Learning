package com.suresh.multi.threading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadExecutorsCacheThreadPool {

	public static void main(String[] args) {
		
		System.out.println("main thread starts");
		
		// unbounded thread pool, with automatic thread reclamation
		// Creates a thread pool that creates new threads as needed, 
		// but will reuse previously constructed threads when they are available. 
		// These pools will typically improve the performance of programs that 
		// execute many short-lived asynchronous tasks. 
		// Calls to execute will reuse previously constructed threads if available. 
		// If no existing thread is available, a new thread will be created and added 
		// to the pool. Threads that have not been used for sixty seconds are terminated 
		// and removed from the cache. Thus, a pool that remains idle for long enough 
		// will not consume any resources
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		executorService.submit(new CachedThreadTask());
		executorService.submit(new CachedThreadTask());
		executorService.submit(new CachedThreadTask());
		
		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isTerminated " + executorService.isShutdown());
		
		executorService.submit(new CachedThreadTask());
		executorService.submit(new CachedThreadTask());
			
		executorService.shutdown();

		System.out.println("isTerminated " + executorService.isTerminated());
		
		System.out.println("isShutdown " + executorService.isShutdown());
		
		// executorService.submit(new CachedThreadTask()); // after executorService shutdown, submitting task(thead instance) will throw RejectedExecution Exception
		
		System.out.println("main thread ends");
	}
}

class CachedThreadTask extends Thread {

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
