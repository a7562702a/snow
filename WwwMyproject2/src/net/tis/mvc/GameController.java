package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/game.tis")
public class GameController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문서내용 response.getWriter().append("Served at: ").append(request.getContextPath());
		//문서내용 ~.append(request.getContextPath());
		//<%@ page ~ contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
		String aaa="FUCK";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter a = response.getWriter(); //out개체생성후 화면출력
		a.println("<img src='images/a2.png' width=200 height=100 >");
		a.println("<img src='images/a2.png' width=200 height=100 >");
		a.println("<img src='images/a2.png' width=200 height=100 > <p>");
		
		a.println("<h2>");
		a.println("<a href='index.jsp'> [index.jsp] </a>");
		a.println("<a href='guestWrite.jsp'> [신규등록] </a>");
		a.println("<a href='aaa.jsp'> [aaa] </a>");
		a.println("</h2>");
		a.println(aaa);
		System.out.println(aaa);
	}//end
	
}//class END












