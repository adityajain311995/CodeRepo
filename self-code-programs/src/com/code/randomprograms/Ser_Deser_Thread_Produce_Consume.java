package com.code.randomprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.code.collection.bean.Company;
import com.code.collection.bean.Employee;

public class Ser_Deser_Thread_Produce_Consume {
	
	String path  = "D:\\GitLab\\Self\\self-code-programs\\resources\\Serial_DeSerial.txt";
	public boolean isFileSet = false;
	public void serialize(Employee emp) {
		File file = null;
		ObjectOutputStream out = null;
		try {
			file = new File(path);
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(emp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}

	public <T> T deSerialize(Class<T> clazz) {
		File file = new File(path);
		ObjectInputStream in = null;
		T t = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			t = clazz.cast(in.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		PrintWriter writer=null;
		try {
			writer = new PrintWriter(file);
			writer.print("");
		} catch (FileNotFoundException e) {}
		finally{
			if(writer!=null)writer.close();
		}
		return t;
	}

	public static void main(String[] args) throws Exception {
		Ser_Deser_Thread_Produce_Consume sd = new Ser_Deser_Thread_Produce_Consume();
		Thread writerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Started (sleep - 5 sec)");
				try {Thread.sleep(5000);} catch (InterruptedException e) {}
				Employee employee = new Employee("Aditya", 121713, 40000, new Company("Sapient", "Bangalore"));
				synchronized (sd) {
					sd.serialize(employee);
					System.out.println(Thread.currentThread().getName()
							+ " File Serialized \n" + employee);
					sd.isFileSet = true;
					Scanner sc = new Scanner(System.in);
					if(sc.hasNext())sd.notify();
				}
				System.out.println(Thread.currentThread().getName() + " notified\n");
			}
		},"[Writer]");

		Thread readerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Started");
				Employee employee;
				synchronized (sd) {
					if (!sd.isFileSet) {
						System.out.println(Thread.currentThread().getName()
								+ " waiting");
						try {
							sd.wait();
						} catch (InterruptedException e) {
						}
					}
					System.out.println(Thread.currentThread().getName()
							+ " wait over");
					employee = sd.deSerialize(Employee.class);
				}
				System.out.println(Thread.currentThread().getName() + " File DeSerialized \n" + employee+"\n");
				sd.isFileSet = false;
			}
		},"[Reader]");
		
		
		writerThread.start();
		readerThread.start();
		
	}

}