package com.skp.countdownlatch.deadlock.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

import com.skp.countdownlatch.deadlock.test.DeadlockCaseCDL;

public class Thread2 implements Runnable{
	private CountDownLatch c;
    private ArrayBlockingQueue<Integer> b;
    public Thread2(CountDownLatch c, ArrayBlockingQueue<Integer> b2) {
        this.c = c; this.b = b2;
    }
    public void run() {
      try {
    	  DeadlockCaseCDL.doWork(Thread2.class);
        c.await();
        DeadlockCaseCDL.doWork(Thread2.class);
        System.out.println("I just dequeue "+b.take());
        System.out.println("I just dequeue "+b.take());
      } catch (InterruptedException ex) {}
   }
}
