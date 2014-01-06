package com.login4hq.thread;

public class TestThreadSleep extends Thread { 

    public void run() {
    	long beginTime = 0;
		long endTime;
        for (int i = 0; i < 5; i++) {
            try {
            	beginTime = System.currentTimeMillis();
            	//设置睡眠
            	Thread.sleep(300); 
                endTime = System.currentTimeMillis() - beginTime;
                System.out.print(this.getName() + " : " + i + "线程睡眠"+endTime+"毫秒！\n" );
                System.out.print(this.getName() + " : " + i + " 线程优先级" + this.getPriority() + "\n");
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 

    public static void main(String[] args) { 
    	TestThreadSleep sleep1 = new TestThreadSleep(); 
    	TestThreadSleep sleep2 = new TestThreadSleep();
    	TestThreadSleep sleep3 = new TestThreadSleep();
    	//设置优先级
    	sleep1.setPriority(MIN_PRIORITY);
    	sleep1.start();    	
    	sleep2.start();
    	try {
    		//join方法
			sleep2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sleep3.start();
    } 
} 
