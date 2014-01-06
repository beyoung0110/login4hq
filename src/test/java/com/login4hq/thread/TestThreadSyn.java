package com.login4hq.thread;

public class TestThreadSyn extends Thread{
	private Integer x = 100;
	
	public int getX() { 
		return x; 
	}

	/*public int fix(int y) { 
	    x = x - y; 
	    return x; 
	}*/
	
	/*public int fix(int y) {
        synchronized (this) {
            x = x - y;
        }
        return x;
    }*/
	
	public synchronized int fix(int y) { 
	    x = x - y; 
	    return x; 
	}
	
	public void run() { 
        for (int i = 0; i < 2; i++) {
        	System.out.println(Thread.currentThread().getName() + " : 操作前foo对象的x值= " + this.getX() + this.getState()); 
            this.fix(30); 
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(Thread.currentThread().getName() + " : 操作后foo对象的x值= " + this.getX()); 
        } 
    }
	
	 public static void main(String[] args) { 
		 	TestThreadSyn r = new TestThreadSyn(); 
	        Thread ta = new Thread(r, "Thread-A"); 
	        Thread tb = new Thread(r, "Thread-B"); 
	        ta.start(); 
	        tb.start(); 
	    } 

}
