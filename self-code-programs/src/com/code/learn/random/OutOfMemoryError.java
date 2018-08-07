package com.code.learn.random;

import java.util.ArrayList;
import java.util.List;

import com.code.bean.Company;
import com.code.bean.Employee;

public class OutOfMemoryError {

	static int count;
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		
		while(true){
			//empList.add(new Employee("Aditya", 123, 42.35, new Company("Sapient", "Banglore")));
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(++count);
					while(true){}
				}
			}).start();;
		}
	}

}
