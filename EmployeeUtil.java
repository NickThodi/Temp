package com.Aditya.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeUtil {

	// EmployeeArrayOperationsImpl eimpl = new EmployeeArrayOperationsImpl();
	File f = new File("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");

	public static Employee constructEmployee(int number, String name, float salary, int age, int doj) {
		Employee employee = new Employee();
		employee.setNumber(number);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setDoj(doj);
		employee.setAge(age);
		return employee;
	}

	static Scanner s = new Scanner(System.in);
	Employee emp = new Employee();

	public static void displayEmployeeInformation(Employee employee) {
		System.out.println(employee);

	}

	public static String getHighestSalary(Employee emp1, Employee emp2) {
		if (emp1.getSalary() > emp2.getSalary()) {
			return emp1.getName();
		} else {
			return emp2.getName();
		}

	}

	public static Employee constructEmployeeObject(Employee employee) {
		Employee newemployeeobject = employee;
		return newemployeeobject;
	}

	public static void olderEmployee(Employee ob1, Employee ob2) {
		if (ob1.getAge() > ob2.getAge()) {
			System.out.println("Employee " + ob1.getName() + " is older than " + ob2.getName());
		} else {
			System.out.println("Employee " + ob2.getName() + " is older than " + ob1.getName());
		}
	}

	public static Employee updateEmployeeSalary(Employee ob3) {
		if (ob3.getSalary() < 10000 && ob3.getAge() > 35) {
			ob3.setSalary(ob3.getSalary() + (ob3.getSalary() * 0.15f));

		} else if (ob3.getSalary() < 15000 && ob3.getAge() > 45) {
			ob3.setSalary(ob3.getSalary() + (ob3.getSalary() * 0.20f));

		} else if (ob3.getSalary() < 20000 && ob3.getAge() > 55) {
			ob3.setSalary(ob3.getSalary() + (ob3.getSalary() * 0.25f));

		}
		return ob3;
	}

	public static void calculateDAandHRAandGross(Employee employee) {
		float da, hra, gross;
		if (employee.getSalary() < 10000) {
			da = (float) (0.08 * employee.getSalary());
			hra = (float) (0.15 * employee.getSalary());
			gross = employee.getSalary() + da + hra;
		} else if (employee.getSalary() < 20000) {
			da = (float) (0.10 * employee.getSalary());
			hra = (float) (0.20 * employee.getSalary());
			gross = employee.getSalary() + da + hra;
		} else if (employee.getSalary() < 30000 && employee.getAge() >= 40) {
			da = (float) (0.15 * employee.getSalary());
			hra = (float) (0.27 * employee.getSalary());
			gross = employee.getSalary() + da + hra;
		} else if (employee.getSalary() < 30000 && employee.getAge() < 40) {
			da = (float) (0.13 * employee.getSalary());
			hra = (float) (0.25 * employee.getSalary());
			gross = employee.getSalary() + da + hra;
		} else {
			da = (float) (0.17 * employee.getSalary());
			hra = (float) (0.30 * employee.getSalary());
			gross = employee.getSalary() + da + hra;
		}
		System.out.println("The gross salary of " + employee.getName() + " is " + employee.getSalary() + "(basic) + "
				+ da + "(da)+ " + hra + " (hra), total= " + gross);
	}

	public static double calculateDAandHRAandGrossforArray(Employee employee) {
		float da, hra;
		double gross;
		if (employee.getSalary() < 10000) {
			da = (float) (0.08 * employee.getSalary());
			hra = (float) (0.15 * employee.getSalary());
			gross = displayGross(da, hra, employee);
		} else if (employee.getSalary() < 20000) {
			da = (float) (0.10 * employee.getSalary());
			hra = (float) (0.20 * employee.getSalary());
			gross = displayGross(da, hra, employee);
		} else if (employee.getSalary() < 30000 && employee.getAge() >= 40) {
			da = (float) (0.15 * employee.getSalary());
			hra = (float) (0.27 * employee.getSalary());
			gross = displayGross(da, hra, employee);
		} else if (employee.getSalary() < 30000 && employee.getAge() < 40) {
			da = (float) (0.13 * employee.getSalary());
			hra = (float) (0.25 * employee.getSalary());
			gross = displayGross(da, hra, employee);
		} else {
			da = (float) (0.17 * employee.getSalary());
			hra = (float) (0.30 * employee.getSalary());
			gross = displayGross(da, hra, employee);

		}
		return gross;
	}

	public static double displayGross(float da, float hra, Employee emp) {
		double grossSalary = da + hra + emp.getSalary();
		System.out.println("The gross salary for the selected employee is " + grossSalary);
		return grossSalary;
	}

	public static void displayUtil(Employee employee) {
		System.out.println(employee);
	}

	public static Employee getValueFromUser() {
		// TODO Auto-generated method stub
		System.out.print("Enter number: ");
		int number = s.nextInt();

		System.out.print("Enter Name: ");
		String name = s.next();

		System.out.print("Enter Salary: ");
		float salary = s.nextFloat();
		
		System.out.print("Enter age: ");
		int age = s.nextInt();

		System.out.print("Enter year of joining: ");
		int doj = s.nextInt();

		System.out.println("-----------------------------------------------------");

		return constructEmployee(number, name, salary, age, doj);

	}

	public static void regexCounter(File input) throws IOException {
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		String regex = "([0-9]*\\.[0-9]+|[0-9]+)";
		int wordCounter = 0;
		int lineCounter = 0;
		int numberCounter = 0;

		String line = "";

		while ((line = br.readLine()) != null) {

			String[] s = line.split(",");
			for (String str : s) {
				wordCounter++;
			}
			lineCounter++;

			for (String st : s) {
				if (st.matches(regex)) {
					numberCounter++;
				}

			}
		}
		System.out.println("The number of lines in the file are: " + lineCounter);
		System.out.println("The number of words in the file are: " + wordCounter);
		System.out.println("The number of numbers in the file are: " + numberCounter);
	}
	
public static void sortData(List<Employee> emp) {
	//	System.out.println(emp);
		Scanner c = new Scanner(System.in);
		System.out.println("How do you want to sort the employees?");
		System.out.println("press n: Sort by names");
		System.out.println("press a: Sort by age and salary");
		
		String choice = c.next();
		
		switch(choice){
		
		case "n": Collections.sort(emp);
		          for(int i=0; i<emp.size(); i++) {
		        	  System.out.println(emp.get(i));
		          }
		          break;
			
		case "a": 
		          Collections.sort(emp, new Employee.EmployeeComparator());
		          for(int i=0; i<emp.size(); i++) {
		        	  System.out.println(emp.get(i));
		          }
		          break;
		}
	}

public static Date getDate(int year) {
	Calendar cal =  Calendar.getInstance();
	cal.set(Calendar.YEAR, year);
	return cal.getTime();
}
}
