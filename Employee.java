package com.Aditya.Employee;

import java.util.Date;
import java.util.Calendar;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private int number;
	private String name;
	private float salary;
	private int age;
	private int doj;
	private static String COMPANY_NAME;
	
	private int employeeId;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private int year;

	public Employee() {
		super();
	}

	public Employee(Employee emp) {
		super();
		this.number = number;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
		this.age = age;
		this.employeeId = employeeId;
	}

	public Employee(int number, String name, float salary, int doj, int age, int employeeId) {
		super();
		this.number = number;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
		this.age = age;
		this.employeeId = employeeId;
	}

	/*
	 * { salary = 10000; }
	 */

	static {
		COMPANY_NAME = "XYZ Comp";
	}

	public static String getCompanyName() {
		return COMPANY_NAME;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * ASSIGNMENT-1 public int getDoj() { return doj; } public void setDoj(Date doj)
	 * { this.doj = doj; } ASSIGNMENT-1
	 */

	public int getDate(int year) {
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(year, month, date);
		// return calendar.getTime();
		return year;
	}

	/*
	 * public int getService(Employee object1, Employee object2) { return (new
	 * Date().getDate()-doj.getDate()); }
	 * 
	 * @Override public String toString() { return "Employee [number=" + number +
	 * ", name=" + name + ", salary=" + salary + ", doj=" + doj + "]"; }
	 * 
	 * /* public Employee setEmployeeInformation(int number, String name, float
	 * salary, Date doj) { Employee employee = new Employee();
	 * employee.setNumber(number); employee.setName(name);
	 * employee.setSalary(salary); employee.setDoj(doj); return employee; }
	 */

	/*
	 * public void displayEmployeeInformation(Employee employee) {
	 * System.out.println(employee);
	 * 
	 * }ASSIGNMENT-1
	 */

	public int getDoj() {
		return doj;
	}

	public void setDoj(int doj) {
		this.doj = doj;
	}
	public static Employee constEmployee(int number, String name, float salary, int age, int year) {
		Employee employee = new Employee();
		employee.setNumber(number);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setYear(year);
		employee.setAge(age);
		System.out.println("Aditya");
		return employee;
	}


	public float calculateHRA(float salary) {
		return (float) (salary * 0.2);
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", salary=" + salary + ", age=" + age + ", doj=" + doj
				+ "]";
	}

	@Override
	public int compareTo(Employee e1) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (name.compareTo(e1.name) > 0)
			return AFTER;
		if (name.compareTo(e1.name) < 0)
			return BEFORE;

		return EQUAL;
	}

	static class EmployeeComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee e1, Employee e2) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			if (e1.getAge() > e2.getAge())
				return BEFORE;
			if (e1.getAge() < e2.getAge())
				return AFTER;

			if (e1.getSalary() > e2.getSalary())
				return BEFORE;
			if (e1.getSalary() < e2.getSalary())
				return AFTER;

			return EQUAL;

		}
	}
}