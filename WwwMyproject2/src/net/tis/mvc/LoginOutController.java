package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; //세션추가

import net.tis.common.DB;
import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;


@WebServlet("/loginout.tis")
public class LoginOutController extends HttpServlet {
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
	
	  HttpSession session = request.getSession();
	  session.invalidate();
	  
	  RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
	  dis.forward(request, response);

	  
	}
	
}//class END













