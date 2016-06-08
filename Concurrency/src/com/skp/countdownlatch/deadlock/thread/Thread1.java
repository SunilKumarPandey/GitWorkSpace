package com.skp.countdownlatch.deadlock.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

import com.skp.countdownlatch.deadlock.test.DeadlockCaseCDL;

public class Thread1 implements Runnable{

	private CountDownLatch c;
    private ArrayBlockingQueue<Integer> b;
    public Thread1(CountDownLatch c, ArrayBlockingQueue<Integer> b2) {
        this.c = c; this.b = b2;
    }
    public void run() {
      try {
        b.put(234);
        b.put(654);
        DeadlockCaseCDL.doWork(Thread1.class);
        c.countDown();
        DeadlockCaseCDL.doWork(Thread1.class);
      } catch (InterruptedException ex) {}
   }
}
