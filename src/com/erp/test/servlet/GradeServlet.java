package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;


public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GradeService gradeService = new GradeServiceImpl();
	
	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(str);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String str = "";
		if("/grade/grade-list".equals(uri)) {
			request.setAttribute("gradeList", gradeService.selectGradeList(null));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/grade/grade-list");
			requestDispatcher.forward(request,response);
		}else if("/grade/grade-view".equals(uri)) {
			String grdno = request.getParameter("grd_no");
			if(grdno == null || "".equals(grdno.trim())) {
				throw new ServletException("입력 없음");
			}
			int gNum = Integer.parseInt(grdno);
			Map<String, Object> grade = gradeService.selectGrade(gNum);
			request.setAttribute("grade", grade);
			RequestDispatcher rd = request.getRequestDispatcher("/view/grade/grade-view");
			rd.forward(request, response);
		}else {
			str = "잘못 들어오셨습니다. 나가";
		}
		doProcess(response, str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	
	}

}
