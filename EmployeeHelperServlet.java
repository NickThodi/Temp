package com.Aditya.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.Aditya.Employee.Employee;
import com.Aditya.Employee.EmployeeDBOperationsImpl;

public class EmployeeHelperServlet {

	public static String prepareResponse(HttpServletRequest request) throws SQLException {
		
        int employeeId = Integer.parseInt(request.getParameter("empId"));

		EmployeeDBOperationsImpl emp = null;
		try {
			emp = new EmployeeDBOperationsImpl();

			Employee e = new Employee();
			e = emp.findEmployee(employeeId);

			if (e.getNumber() == 0) {
				request.setAttribute("message", "The id you entered is invalid, please try again");
			} else {
				request.setAttribute("emp", e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			if (e instanceof ClassNotFoundException) {
				System.out.println("Employee does not exist");
			}
		}
		return null;
	}
}
