package com.suresh.multi.threading.basic;


public class MyThreadStartMethod {

	public static void main(String[] args) {
		
		System.out.println("main thread starts");
		Thread t1 = new StartTask();
		Thread t2 = new StartTask();
		t1.start();
		t2.start();
		new StartTask().start();
		new StartTask().start();
		System.out.println("main thread ends");
	}
}

class StartTask extends Thread {

	@Override
	public void run() {
		System.out.println("Thread starting - " + this.getName());
		
		try{
			for(int i=1; i<=10; i++){
				System.out.println("task " + i + " from " + this.getName());
				Thread.sleep(1000);
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Thread ending - " + this.getName());
	}	
}
