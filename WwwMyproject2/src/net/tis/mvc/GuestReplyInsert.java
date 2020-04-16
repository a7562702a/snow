package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;
import net.tis.guest.ReplyDTO;
import net.tis.guest.ReplySQL;


@WebServlet("/greplyInsert.tis")
public class GuestReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
			
		ReplyDTO  rdto = new ReplyDTO(); 
		ReplySQL  rsql = new ReplySQL();
		
		 String a = request.getParameter("writer");
	     String b = request.getParameter("content");
	     int c = Integer.parseInt(request.getParameter("sabun"));
	     
	     rdto.setContent("content");
	     rdto.setWriter("writer");  
	     rdto.setSabun(Integer.parseInt(request.getParameter("sabun")));
	     
	     System.out.println("������� GuestReplyInsert.java");
	     System.out.println("�Ѿ�´�� ������ " + a + " " + b + " " + c);
	     rsql.dbReplyInsert(a, b, c);
	     response.sendRedirect("gdetail.tis?Gidx="+c);
	}//end
	
}//class END













