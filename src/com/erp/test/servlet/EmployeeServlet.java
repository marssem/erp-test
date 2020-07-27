package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.EmployeeService;
import com.erp.test.service.impl.EmployeeServiceImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private EmployeeService emp = new EmployeeServiceImpl();
	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(str);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/employee/employee-list".equals(uri)) {
			request.setAttribute("employeeList", emp.selectEmployeeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-List");
			rd.forward(request, response);
		}else if("/employee/employee-view".equals(uri)) {
			Map<String, Object> employee = new HashMap<>();
			employee.put("grd_no", request.getParameter("grd_no"));
			request.setAttribute("employee", emp.selectEmployee(employee));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-view");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if("/employee/employee-update".equals(uri)) {
			Map<String, Object> employee = new HashMap<>();
			employee.put("emp_no", request.getParameter("emp_no"));
			employee.put("emp_name", request.getParameter("emp_name"));
			employee.put("emp_salary", request.getParameter("emp_salary"));
			employee.put("grd_no", request.getParameter("grd_no"));
			Map<String, Object> rMap = emp.updateEmployee(employee);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap", rMap);
		} else if("/employee/employee-delete".equals(uri)) {
			Map<String, Object> employee = new HashMap<>();
			employee.put("emp_no", request.getParameter("emp_no"));
			Map<String, Object> rMap = emp.deleteEmployee(employee);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap", rMap);
		}else if("/employee/employee-insert".equals(uri)) {
			Map<String,Object> employee = new HashMap<>();
			employee.put("emp_name", request.getParameter("emp_name"));
			employee.put("emp_salary", request.getParameter("emp_salary"));
			employee.put("grd_no", request.getParameter("grd_no"));
			Map<String,Object> rMap = emp.insertEmployee(employee);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap",rMap);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
	}

}
