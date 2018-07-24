package com.code.learn.random;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Thread_notifyAll extends Object {

	private List synchedList;

	public Thread_notifyAll() {
		// create a new synchronized list to be used
		synchedList = Collections.synchronizedList(new LinkedList());
	}

	// method used to remove an element from the list
	public String removeElement() throws InterruptedException {
		synchronized (synchedList) {

			// while the list is empty, wait
			while (synchedList.isEmpty()) {
				System.out.println("Thread["+Thread.currentThread().getName()+"] : List is empty...");
				synchedList.wait();
				System.out.println("Thread["+Thread.currentThread().getName()+"] : Waiting Over...");
			}
			String element = (String) synchedList.remove(0);

			return element;
		}
	}

	// method to add an element in the list
	public void addElement(String element) {
		System.out.println("Thread["+Thread.currentThread().getName()+"] : Opening...");
		synchronized (synchedList) {

			// add an element and notify all that an element exists
			synchedList.add(element);
			System.out.println("Thread["+Thread.currentThread().getName()+"] : New Element:'" + element + "'");

			synchedList.notifyAll();
			System.out.println("Thread["+Thread.currentThread().getName()+"] : notifyAll called!");
		}
		System.out.println("Thread["+Thread.currentThread().getName()+"] : Closing...");
	}

	public static void main(String[] args) {
		final Thread_notifyAll demo = new Thread_notifyAll();

		Runnable runA = new Runnable() {

			public void run() {
				try {
					String item = demo.removeElement();
					System.out.println("Thread["+Thread.currentThread().getName()+"] : Removed : " + item);
				} catch (InterruptedException ix) {
					System.out.println("Thread["+Thread.currentThread().getName()+"] : Interrupted Exception!");
				} catch (Exception x) {
					System.out.println("Thread["+Thread.currentThread().getName()+"] : Exception thrown.");
				}
			}
		};

		Runnable runB = new Runnable() {

			// run adds an element in the list and starts the loop
			public void run() {
				demo.addElement("Hello!");
			}
		};

		try {
			Thread threadA1 = new Thread(runA, "A1");
			threadA1.setPriority(10);
			threadA1.start();

			Thread.sleep(500);

			Thread threadA2 = new Thread(runA, "A2");
			threadA2.start();

			Thread.sleep(500);

			Thread threadA3 = new Thread(runA, "A3");
			threadA3.start();

			Thread.sleep(500);
			
			Thread threadA4 = new Thread(runA, "A4");
			threadA4.start();

			Thread.sleep(500);
			
			Thread threadA5 = new Thread(runA, "A5");
			threadA5.setPriority(10);
			threadA5.start();

			Thread.sleep(500);

			Thread threadA6 = new Thread(runA, "A6");
			threadA6.start();

			Thread.sleep(500);

			Thread threadA7 = new Thread(runA, "A7");
			threadA7.start();

			Thread.sleep(500);
			
			Thread threadA8 = new Thread(runA, "A8");
			threadA8.start();

			Thread.sleep(500);
			
			Thread threadR = new Thread(runB, "R");
			threadR.start();

			Thread.sleep(1000);

			threadA5.interrupt();
			threadA7.interrupt();
		} catch (InterruptedException x) {
		}
	}
}