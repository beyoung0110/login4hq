package com.login4hq.thread;

public class TestThread extends Thread{
	private String name;
	public TestThread(String name){
		this.name = name;
	}
	
	public void run() { 
        for(int i = 0;i<5;i++){ 
            for(long k= 0; k <100000000;k++); 
            System.out.println(this.name+" :"+i); 
        } 
    }
	
	public static void main(String[] args){
		/**
		 * 创建两个线程
		 */		
		TestThread testThread1 = new TestThread("线程1");
		TestThread testThread2 = new TestThread("线程2");
		testThread1.start();
		testThread2.start();
		/**
		 * 用循环创建若干个线程
		 */
		/*for(Integer threadNum = 1;threadNum<4;threadNum++){
			TestThread testThread1 = new TestThread("线程 " + threadNum.toString());
			testThread1.start();
		}	*/	
	}	
}
