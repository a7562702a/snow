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


@WebServlet("/login.tis")
public class LoginController extends HttpServlet {
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
	
	  //out.println("LoginController.java컨트롤러문서");
	  //HttpSession session = request.getSession();
	  try{
		  	Connection CN=DB.getConnection();
		  	int total=0;
		   	
		  	String usera=request.getParameter("UID");
		   	String userb=request.getParameter("UPWD");
		   	System.out.println("UID=" + usera + "  UPWD=" + userb) ;
		   	String  msg="select count(*) as cnt from cbuser where sabun=?  and pwd=?" ;
		     PreparedStatement PST=CN.prepareStatement(msg); //쿼리문미리서해석    
		   		PST.setString(1, usera);
		   		PST.setString(2, userb);
		     ResultSet RS=PST.executeQuery();
		     if(RS.next()==true){total=RS.getInt("cnt"); }
		     if(total>0){

		     	 HttpSession session = request.getSession();
		     	 session.setAttribute("google", usera); //세션설정
		     	 System.out.println("google세션설정성공OK");
		     	 RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
				 dis.forward(request, response);

		     }else{
		        out.println("<font size=7 color=red><b>" + usera+"님  Ajax컨트롤 로그인실패</b></font><p>");
		        out.println("<img src='./images/cb1.jpeg'>");
		        out.println("<br>");
                out.println("<a href='index.jsp'><b>[Index]</b></a>");
		      }
		    }catch(Exception ex){  }	
	}//end
	
}//class END













