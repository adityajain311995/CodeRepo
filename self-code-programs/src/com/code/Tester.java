package com.code;

public class Tester {

	public static void main(String[] args) {
		Student s1 = new Student("Shafaet", 3.7, 34);
		Student s2 = new Student("Samiha", 3.85, 86);
		
		System.out.println(s2.compareTo(s1));
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
			return s1.getName().compareTo(s2.getName());
		}

		if (s1.getId() > s2.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

}
