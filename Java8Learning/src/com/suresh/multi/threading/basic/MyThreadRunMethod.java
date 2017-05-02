package com.suresh.multi.threading.basic;


public class MyThreadRunMethod {

	public static void main(String[] args) {
		
		System.out.println("main thread starts");
		Thread t1 = new RunTask();
		Thread t2 = new RunTask();
		t1.run();
		t2.run();
		new RunTask().run();
		new RunTask().run();
		System.out.println("main thread ends");
	}
}

class RunTask extends Thread {

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
