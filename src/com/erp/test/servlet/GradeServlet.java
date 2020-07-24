package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			request.setAttribute("grade", gradeService.selectGrade(grade));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-view");
			rd.forward(request, response);
			
			/*
			 * String grdno = request.getParameter("grd_no"); if(grdno == null ||
			 * "".equals(grdno.trim())) { throw new ServletException("입력 없음"); } int gNum =
			 * Integer.parseInt(grdno); Map<String, Object> grade =
			 * gradeService.selectGrade(grdno); request.setAttribute("grade", grade);
			 * RequestDispatcher rd =
			 * request.getRequestDispatcher("/views/grade/grade-view"); rd.forward(request,
			 * response); }else { str = "잘못 들어오셨습니다. 나가";
			 */
		}
//		doProcess(response, str);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if("/grade/grade-update".equals(uri)) {
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			grade.put("grd_name", request.getParameter("grd_name"));
			grade.put("grd_desc", request.getParameter("grd_desc"));
			Map<String, Object> rMap = gradeService.updateGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap", rMap);
		} else if("/grade/grade-delete".equals(uri)) {
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			Map<String, Object> rMap = gradeService.deleteGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap", rMap);
		}else if("/grade/grade-insert".equals(uri)) {
			Map<String,Object> grade = new HashMap<>();
			grade.put("grd_name", request.getParameter("grd_name"));
			grade.put("grd_desc", request.getParameter("grd_desc"));
			Map<String,Object> rMap = gradeService.insertGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap",rMap);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request, response);
		
		/*
		 * if ("/grade/insert".equals(uri)) { String gNo =
		 * request.getParameter("grd_no"); String gName =
		 * request.getParameter("grd_name"); String gDesc =
		 * request.getParameter("grd_desc"); Map<String, Object> grade = new
		 * HashMap<>(); grade.put("grd_no", gNo); grade.put("grd_name", gName);
		 * grade.put("grd_desc", gDesc); Map<String, Object> rMap =
		 * gradeService.insertGrade(grade); doProcess(response, rMap.toString()); }else
		 * if("/grade/update".equals(uri)) { String gNo =
		 * request.getParameter("grd_no"); String gName =
		 * request.getParameter("grd_name"); String gDesc =
		 * request.getParameter("grd_desc"); int mNum =
		 * Integer.parseInt(request.getParameter("grd_no")); Map<String, Object> grade =
		 * new HashMap<>(); grade.put("grd_no", gNo); grade.put("grd_name", gName);
		 * grade.put("grd_desc", gDesc); doProcess(response,
		 * gradeService.updateGrade(grade).toString()); }else
		 * if("/grade/delete".equals(uri)) { int gNum =
		 * Integer.parseInt(request.getParameter("grd_no")); doProcess(response,
		 * gradeService.deleteGrade(null).toString()); }
		 */
		
	}
	}


