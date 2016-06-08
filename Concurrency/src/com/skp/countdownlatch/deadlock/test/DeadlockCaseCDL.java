package com.skp.countdownlatch.deadlock.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

import com.skp.countdownlatch.deadlock.thread.Thread1;
import com.skp.countdownlatch.deadlock.thread.Thread2;

public class DeadlockCaseCDL {
	 public static void main(String[] args) throws InterruptedException {
	        CountDownLatch c = new CountDownLatch(1);
	        ArrayBlockingQueue<Integer> b = new ArrayBlockingQueue<Integer>(1);
	 
	        new Thread(new Thread1(c, b)).start();
	        new Thread(new Thread2(c, b)).start();
	    }
	 
	 public static void doWork(Class classz) {
	        System.out.println(classz.getName()+" do the work");
	    }

}
