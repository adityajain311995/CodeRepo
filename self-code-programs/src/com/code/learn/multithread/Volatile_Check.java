package com.code.learn.multithread;

public class Volatile_Check {

	public static void main(String[] args) {
		Counter counter = new Counter();

		Thread task1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10_000_000; i++) {
					counter.increment();
				}
				System.out.println("task 1");
			}
		});
		task1.start();
		
		Thread task2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10_000_000; i++) {
					counter.incrementVolatileCount();
				}
				System.out.println("task 2");
			}
		});
		task2.start();
		
		/*Wait until both threads are dead*/
		int time_1 = 0;
		int time_2 = 0;
		while(task1.isAlive() || task2.isAlive()) {
			if(task1.isAlive())time_1++;
			if(task2.isAlive())time_2++;
		};
		
		System.out.println("counter = "+counter.getCount());
		System.out.println("volatileCounter = "+counter.getVolatileCount());
		
		System.out.println("Task_1 time : "+time_1);
		
		System.out.println("Task_2 time : "+time_2);
		
	}

}
