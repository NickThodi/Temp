package com.Aditya.Employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionsEmployeeOperationsImpl implements IEmployeeOperations {

	EmployeeArrayOperationsImpl eaoi = new EmployeeArrayOperationsImpl();

	public List<Employee> emplist = new ArrayList<Employee>();

	@Override
	public void createEmployee(Employee employee) throws InvalidSalaryException, Exception {
		if (employee.getSalary() < 5000) {
			throw new InvalidSalaryException("salary should be more than $5000");
		}
		emplist.add(employee);
	}

	@Override
	public Employee findEmployee(int empId) {
		boolean flag = false;
		for (Employee e : emplist) {
			if (e.getNumber() == empId) {
				System.out.println(emplist.get(empId - 1));
				flag = true;
			}
		}

		if (flag == false) {
			System.out.println("Your entry does not match any employee in our records");

		}
		return null;

	}

	@Override
	public Employee findEmployee(String name) {
		for (int i = 0; i < emplist.size(); i++) {
			if (emplist.get(i).getName().equals(name)) {
				System.out.println(emplist.get(i));
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {
		boolean condition = false;
		for (int i = 0; i < emplist.size(); i++) {
			if (emplist != null) {
				condition = true;
				if (emplist.get(i).getNumber() == empId) {

					emplist.remove(emplist.get(i));
				}
				if (condition == false) {
					throw new EmployeeNotFoundException(
							"The id you entered does not match with any of the employees in the records ");
				}
			}
		}
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {

		boolean condition = false;
		for (int i = 0; i < emplist.size(); i++) {
			if (emplist.get(i).getNumber() == employee.getNumber()) {
				emplist.get(i).setNumber(employee.getNumber());
				emplist.get(i).setName(employee.getName());
				emplist.get(i).setSalary(employee.getSalary());
				emplist.get(i).setAge(employee.getAge());
				emplist.get(i).setDoj(employee.getDoj());

			}
		}
		return true;
	}

	@Override
	public Double calculateGrossSal(int empId) {
		double grossSalary;
		for (Employee empl : emplist) {
			if (empl.getNumber() == empId) {
				grossSalary = EmployeeUtil.calculateDAandHRAandGrossforArray(empl);
				return grossSalary;
			}
		}
		return null;
	}

	public List readCSV(File inputFile) throws Exception {

		File file = new File("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");

		Reader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);

			String line = null;
			boolean keepReading = true;

			int index = 0;
			while (keepReading) {
				line = br.readLine();

				if (line == null || line.equals("")) {
					break;
				}
				if (index != 0) {
					Employee emp = parseLine(line);
					emplist.add(emp);
				}
				index++;
			}
		} finally {
			br.close();
			fr.close();
		}
		return emplist;
	}

	private Employee parseLine(String line) {
		String[] str = line.split(",");
		Employee emp = EmployeeUtil.constructEmployee(Integer.parseInt(str[0]), str[1], Float.parseFloat(str[2]),
				Integer.parseInt(str[3]), Integer.parseInt(str[4]));
		return emp;
	}

	public List writeCSV() throws FileNotFoundException, IOException {
		String delimiter = ",";
		String header = "number, name, salary, age, date of joining";
		FileWriter fw = new FileWriter("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");
		try {
			fw.append(header);
			for (Employee emp : emplist) {
				if (emp != null) {
					fw.append("\n");
					fw.append(String.valueOf(emp.getNumber()));
					fw.append(delimiter);
					fw.append(String.valueOf(emp.getName()));
					fw.append(delimiter);
					fw.append(String.valueOf(emp.getSalary()));
					fw.append(delimiter);
					fw.append(String.valueOf(emp.getAge()));
					fw.append(delimiter);
					fw.append(String.valueOf(emp.getDoj()));
				}
			}
		} finally {
			fw.flush();
			fw.close();
		}
		return null;
	}

	public void getUniqueNames(List<Employee> list) {
		Set<String> nameSet = new TreeSet<String>();
		for (int i = 0; i < list.size(); i++) {
			nameSet.add(list.get(i).getName());
		}
		System.out.println(nameSet);
	}

	public void getEmployeeCount(List<Employee> lemp) {
		int twentiesCounter = 0;
		int thirtiesCounter = 0;

		for (int i = 0; i < lemp.size(); i++) {
			if (lemp.get(i).getAge() > 20 && lemp.get(i).getAge() < 30) {
				twentiesCounter++;
			} else if (lemp.get(i).getAge() > 30 && lemp.get(i).getAge() < 40) {
				thirtiesCounter++;
			}
		}
		System.out.println("20-30: " + twentiesCounter);
		System.out.println("30-40: " + thirtiesCounter);
	}

	public void display() {

		Iterator<Employee> itr = emplist.iterator();

		while (itr.hasNext()) {
			Employee empl = itr.next();
			System.out.println(empl);
		}
	}
}