package com.Aditya;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Aditya.util.EmployeeHelperServlet;

/**
 * Servlet implementation class EmpJDBCServlet
 */
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private int empId;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("pages/EmployeeSearch.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        try {
			String responseBody = EmployeeHelperServlet.prepareResponse(request);
			//response.setContentType("text/html");
			//response.getWriter().append(responseBody);
			request.setAttribute("employee", responseBody);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //request.setAttribute("empId", null);
		doGet(request, response);
	}

}
