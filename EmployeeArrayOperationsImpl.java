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
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeArrayOperationsImpl implements IEmployeeOperations {

	private int idnum, index = 0;
	private int arraySize = 0;
	int doj;

	Employee[] empArr = null;

	Scanner input = new Scanner(System.in);

	public EmployeeArrayOperationsImpl() {
		super();
	}

	@Override
	public void createEmployee(Employee employee) throws Exception {
		if (employee.getSalary() < 5000) {
			throw new InvalidSalaryException("salary should be more than $5000");
		}
		empArr[index] = employee;
		index++;
		arraySize++;
	}

	public EmployeeArrayOperationsImpl(int idnum) {
		super();
		this.idnum = idnum;
		empArr = new Employee[idnum];
	}

	public void display() {
		for (index = 0; index < arraySize; index++) {
			System.out.println(empArr[index]);
		}
	}

	@Override
	public Employee findEmployee(int empId) {
		return empArr[empId - 1];
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {
		boolean condition = false;
		for (int i = 0; i < arraySize; i++) {
			if (empArr[i] != null) {
				if (empArr[i].getNumber() == empId) {
					condition = true;
					for (int j = i; j < arraySize; j++) {
						empArr[j] = empArr[j + 1];
					}
					if (condition == false) {
						throw new EmployeeNotFoundException(
								"The id you entered does not match with any of the employees in the records ");
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean condition = false;
		for (int i = 0; i < arraySize; i++) {
			if (empArr[i].getNumber() == employee.getNumber()) {
				condition = true;
			}
		}
		if (condition == false) {
			throw new EmployeeNotFoundException("The employee Id you entered does not exist in our records ");
		} else {
			for (int i = 0; i < arraySize; i++) {
				if (employee.getNumber() == empArr[i].getNumber()) {
					empArr[i].setNumber(employee.getNumber());
					empArr[i].setName(employee.getName());
					empArr[i].setSalary(employee.getSalary());
					empArr[i].setAge(employee.getAge());
					empArr[i].setDoj(employee.getDoj());
				}
			}
			empArr[employee.getNumber() - 1] = employee;
			return false;
		}
	}

	@Override
	public Double calculateGrossSal(int empId) {
		double grossSalary;
		for (Employee empl : empArr) {
			if (empl.getNumber() == empId) {
				grossSalary = EmployeeUtil.calculateDAandHRAandGrossforArray(empl);
				return grossSalary;
			}
		}
		return null;
	}

	private Employee parseLine(String line) {
		String[] str = line.split(",");
		Employee emp = EmployeeUtil.constructEmployee(Integer.parseInt(str[0]), str[1], Float.parseFloat(str[2]),
				Integer.parseInt(str[3]), Integer.parseInt(str[4]));
		return emp;
	}

	public Employee[] readCSV(File inputFile) throws Exception {
		empArr = new Employee[idnum];
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
					empArr[index - 1] = emp;
				}
				index++;
			}
		} finally {
			br.close();
			fr.close();
		}
		return empArr;
	}

	public void writeCSV() throws FileNotFoundException, IOException {
		String delimiter = ",";
		String header = "number, name, salary, age, date of joining";
		FileWriter fw = new FileWriter("C:\\Users\\adity\\Desktop\\Assignments\\Employee.csv");
		try {
			fw.append(header);
			for (Employee emp : empArr) {
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
	}

	public void displayMenu() {
		System.out.println("==================== User Menu ====================");
		System.out.println("Select what you want to do");
		System.out.println("\na.) Create new Employee record");
		System.out.println("b.) Find employee by employee id");
		System.out.println("c.) Find employee by name");
		System.out.println("d.) Delete employee by id");
		System.out.println("e.) Update Employee records");
		System.out.println("f.) Calculate employee's gross salary by emp id.");
		System.out.println("g.) Display Employee list");
		// System.out.println("h.) Word/Line/Number Counter"); for collections
		System.out.println("h.) Sort Employees list");
		System.out.println("i.) Display Unique Employee names");
		System.out.println("j.) Display number of Employees within a given age range");
		System.out.println("k.) Save & Exit");
		System.out.println("\nWhat's your choice?");
	}

	@Override
	public Employee findEmployee(String name) {
		int findByName = 0;
		System.out.println(empArr);
		for (int j = 0; j < arraySize; j++) {
			if (empArr[j].getName().equals(name)) {
				findByName = j;
			}
		}
		return empArr[findByName];
	}
}
