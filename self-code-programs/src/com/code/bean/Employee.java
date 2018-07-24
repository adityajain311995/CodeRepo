package com.code.bean;

public class Employee {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1234L;

	String name;
	int id;
	double salary;
	Company company;

	public Employee(String name, int id, double salary, Company company) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary
				+ ", company=" + company + "]";
	}
	
}
