package com.code.learn.multithread;

public class Producer_Consumer_basic {
	public static void main(String[] args) {
		AnyObject obj = new AnyObject("aditya");

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.produce();
			}
		}, "thread-1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.consume();
			}
		}, "thread-2");

		t1.start();
		t2.start();
	}
}

class AnyObject {
	private String value;
	private int counter = 0;
	
	public AnyObject(String value) {
		this.value = value;
	}

	public void produce() {
		while (true) {
			//System.out.println("Producer Start");
			synchronized (this) {
				try {
					while (value != null) {
						wait();
					}
				} catch (InterruptedException e) {
					System.out.println("Producer wait() error occured");
				}
				value = "Produced --> " + ++counter;
				System.out.println(value);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Producer sleep() error occured");
				}
				notify();
			}
		}
	}

	public void consume() {
		while (true) {
			//System.out.println("Consumer Start");
			synchronized (this) {
				try {
					while (value == null) {
						wait();
					}
				} catch (InterruptedException e) {
					System.out.println("Consumer wait() error occured");
				}

				System.out.println("Consumed --> " + counter);
				value = null;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Consumer sleep() error occured");
				}

				notify();
			}
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
