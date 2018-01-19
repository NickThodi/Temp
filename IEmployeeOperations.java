package com.Aditya.Employee;

interface IEmployeeOperations {
	
	  void createEmployee(Employee employee) throws InvalidSalaryException, Exception;

	    Employee findEmployee(int empId);
	    
	    Employee findEmployee(String name);

	    boolean deleteEmployee(int empId) throws EmployeeNotFoundException;

	    boolean updateEmployee(Employee employee) throws EmployeeNotFoundException;

	    Double calculateGrossSal(int empId);
}
