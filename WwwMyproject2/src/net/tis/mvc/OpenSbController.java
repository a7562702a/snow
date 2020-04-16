package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


@WebServlet("/openSbSave.tis")
public class OpenSbController extends HttpServlet {
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
	  
	try {
		  int total=0;
		  Connection CN=DB.getConnection();
		  String data = request.getParameter("userid");
		  String msg="select count(*) as cnt from cbuser where sabun="+data;
		  Statement ST;
		  ST = CN.createStatement();
		  ResultSet RS = ST.executeQuery(msg);
		  if(RS.next()==true){total=RS.getInt("cnt"); }
		  request.setAttribute("total",total);
		  request.setAttribute("data", data);
		  RequestDispatcher dis=request.getRequestDispatcher("openSbSave.jsp");
		  dis.forward(request,response);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
	  
	}
}//class END













