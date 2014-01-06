package com.login4hq.thread;

public  class TestRunnable implements Runnable {
	private String name;
	
	public TestRunnable(String name){
		this.name = name;
	}
	
	public void run() { 
        for (int i = 0; i < 5; i++) { 
            for (long k = 0; k < 100000000; k++) ; 
            System.out.println(name + ": " + i); 
        } 
    }
	
	public static void main(String[] args){
		TestRunnable ds1 = new TestRunnable("线程1"); 
        TestRunnable ds2 = new TestRunnable("线程2"); 

        Thread t1 = new Thread(ds1); 
        Thread t2 = new Thread(ds2); 

        t1.start(); 
        t2.start();		
	}	
}
