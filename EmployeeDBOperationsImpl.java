package com.Aditya.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeDBOperationsImpl implements IEmployeeOperations {
	Scanner input = new Scanner(System.in);
	Connection con = null;
	ResultSet rs = null;

	public EmployeeDBOperationsImpl() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs_assignments", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployee(Employee employee) throws InvalidSalaryException, Exception {

		PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?,?)");

		stmt.setInt(1, employee.getNumber());
		stmt.setString(2, employee.getName());
		stmt.setFloat(3, employee.getSalary());
		stmt.setInt(4, employee.getAge());
		stmt.setInt(5, employee.getDoj());

		stmt.executeUpdate();
	}

	@Override
	public Employee findEmployee(int empId) {

		Employee emp =  new Employee();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from employee where number = ?");
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5));
			emp = emp.constEmployee(Integer.parseInt(rs.getString(1)), rs.getString(2), Float.parseFloat(rs.getString(3)), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)));
			}

			 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return emp;
	}

	@Override
	public Employee findEmployee(String name) {
		try {
			PreparedStatement stmt = con.prepareStatement("select * from employee where name = ?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {

		try {
			PreparedStatement stmt = con.prepareStatement("delete from employee where number = ?");
			stmt.setInt(1, empId);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {
		try {
			PreparedStatement stmt = con
					.prepareStatement("update employee set name = ?, salary = ?, age = ?, doj = ? where number = ? ");
			stmt.setString(1, employee.getName());
			stmt.setFloat(2, employee.getSalary());
			stmt.setInt(3, employee.getAge());
			stmt.setInt(4, employee.getDoj());
			stmt.setInt(5, employee.getNumber());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Double calculateGrossSal(int empId) {

		try {
			/*PreparedStatement stmt = con.prepareStatement("Select * from imcs_assignments.employee where number = ?");
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();*/

			while (rs.next()) {
				int number = rs.getInt(1);
				String name = rs.getString(2);
				float salary = rs.getFloat(3);
				int age = rs.getInt(4);
				int doj = rs.getInt(5);

				System.out.println(name + "\t" + EmployeeUtil.calculateDAandHRAandGrossforArray(
						EmployeeUtil.constructEmployee(number, name, salary, age, doj)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void display() {
		try {
			PreparedStatement stmt = con.prepareStatement("Select * from imcs_assignments.employee");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getInt(4)
						+ " " + rs.getInt(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sortDataByName() {
		try {
			PreparedStatement stmt = con.prepareStatement("Select * from imcs_assignments.employee order by name");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getInt(4)
						+ " " + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortDataByAgeSalary() {
		try {
			PreparedStatement stmt = con
					.prepareStatement("Select * from imcs_assignments.employee order by age, salary");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getInt(4)
						+ " " + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getUniqueNames() {

		try {
			PreparedStatement stmt = con.prepareStatement("Select distinct name from imcs_assignments.employee");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getEmployeeCount() {

		try {
			PreparedStatement stmt = con
					.prepareStatement("Select count(*) from imcs_assignments.employee where age > 20 and age < 30");
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Employees in the age range 20-30 years: " + rs.getInt(1));
			}
			rs.close();
			PreparedStatement stmt1 = con
					.prepareStatement("Select count(*) from imcs_assignments.employee where age > 30 and age < 40");

			rs = stmt1.executeQuery();
			while (rs.next()) {
				System.out.println("Employees in the age range 30-40 years: " + rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
