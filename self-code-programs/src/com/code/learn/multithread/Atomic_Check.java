package com.code.learn.multithread;

public class Atomic_Check {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		
		Thread task1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 14_000_000; i++) {
					counter.increment();
					counter.incrementAtomic();
					counter.incrementSynced();
				}
				System.out.println("task 1");
			}});
		task1.start();
		
		Thread task2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 6_000_000; i++) {
					counter.increment();
					counter.incrementAtomic();
					counter.incrementSynced();
				}
				System.out.println("task 2");
			}});
		task2.start();
		
		/*Wait until both threads are dead*/
		while(task1.isAlive() || task2.isAlive()) {};
		
		System.out.println("counter = "+counter.getCount());
		System.out.println("atomiCounter = "+counter.getAtomicCount());
		System.out.println("syncedCounter = "+counter.getSyncedCount());
	}

}
