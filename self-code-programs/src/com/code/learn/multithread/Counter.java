package com.code.learn.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private int count;
	private AtomicInteger atomicCount = new AtomicInteger(0);
	private int syncedCount;
	private volatile int volatileCount;
	
	public int getCount() {
		return count;
	}
	
	public int increment() {
		return count++;
	}
	
	public AtomicInteger getAtomicCount() {
		return atomicCount;
	}
	
	/**
	 *  
	 * Atomic increment in a one go unlike non-atomic objects.
	 * Non-atomic increment would take 3 steps. read, increment and write to cache.
	 * Atomic object performs these 3 task virtually in 1 go(synchronously)
	 * 
	 */
	public AtomicInteger incrementAtomic() {
		atomicCount.getAndAdd(1);
		return atomicCount;
	}
	
	public int getSyncedCount() {
		return syncedCount;
	}
	
	/**
	 * 
	 * Only one thread can access this code at a time
	 * 
	 */
	public synchronized int incrementSynced() {
		return syncedCount++;
	}
	
	public int getVolatileCount() {
		return volatileCount;
	}
	
	/**
	 * 
	 * Volatile takes lot more time than non-volatile since
	 * volatile filed is set to the main memory every time 
	 * updated is done. Non-volatile fields get saved to only
	 * the cache 
	 * 
	 */
	public int incrementVolatileCount() {
		return volatileCount++;
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.incrementAtomic();
		System.out.println(counter.getAtomicCount());
	}
}
