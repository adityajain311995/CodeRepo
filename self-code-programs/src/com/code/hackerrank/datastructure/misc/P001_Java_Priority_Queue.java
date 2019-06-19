package com.code.hackerrank.datastructure.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 * 
 * @author adijain4
 *
 */
public class P001_Java_Priority_Queue {
	public static void main(String[] args) {
		String[] list = {	"ENTER John 3.75 50",
							"ENTER Mark 3.8 24",
							"ENTER Shafaet 3.7 35",
							"SERVED",
							"SERVED",
							"ENTER Samiha 3.85 36",
							"SERVED",
							"ENTER Ashley 3.9 42",
							"ENTER Maria 3.6 46",
							"ENTER Anik 3.95 49",
							"ENTER Dan 3.95 50",
							"SERVED"};
		Priorities pro = new Priorities();
		pro.getStudents(Arrays.asList(list));
	}
}

class PriorityQueue<T extends Comparable<T>> {
	int items;
	Object[] array;

	PriorityQueue() {
		this.items = 0;
		array = new Object[10];
	}

	public void insert(T obj) {
		if (items == 0) {
			array[items] = obj;
			items++;
			System.out.println(getElements());
			return;
		}
		if (array.length == items) {
			array = Arrays.copyOf(array, items * 2);
		}
		int i;
		for (i = items - 1; i >= 0; i--) {
			if (obj.compareTo((T) array[i]) < 0) {
				array[i + 1] = array[i];
			} else {
				break;
			}
		}
		array[i + 1] = obj;
		items++;
		System.out.println(getElements());
	}

	public void remove() {
		if (items == 0) {
			return;
		}

		array[items - 1] = null;
		items--;
		System.out.println(getElements());
	}

	public List<T> getElements() {
		List<T> list = new ArrayList<>();
		for (int i = items-1; i >=0; i--) {
			list.add((T) array[i]);
		}
		return list;
	}
}

class Priorities {
	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> queue = new PriorityQueue();
		for (String event : events) {
			String[] list = event.split(" ");
			if (list[0].equals("SERVED")) {
				queue.remove();
			} else {
				queue.insert(new Student(list[1], Double.parseDouble(list[2]), Integer.parseInt(list[3])));
			}
		}

		return queue.getElements();
	}
}

class Student implements Comparable<Student> {
	private String name;
	private double cgpa;
	private int id;

	public Student(String name, double cgpa, int id) {
		this.name = name;
		this.cgpa = cgpa;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCGPA() {
		return cgpa;
	}

	public void setCGPA(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public int compareTo(Student s2) {
		Student s1 = this;
		if (s1.getCGPA() != s2.getCGPA()) {
			if (s1.getCGPA() > s2.getCGPA()) {
				return 1;
			} else {
				return -1;
			}
		}

		if (!s1.getName().equals(s2.getName())) {
			return s2.getName().compareTo(s1.getName());
		}

		if (s1.getId() > s2.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return name + " " + cgpa;
	}

	
	
}