package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;


@WebServlet("/sinsert.tis")
public class SignUpInsertController extends HttpServlet {
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
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); 
		
		out.println("<img src='images/a1.png' width=200 height=100 >");
		out.println("<img src='images/a1.png' width=200 height=100 >");
		out.println("<img src='images/a1.png' width=200 height=100 > <p>");
		
		
		ServletContext context =  this.getServletContext();
		ServletContext application =  this.getServletContext();
		
		  String path=application.getRealPath("./storage");
		  System.out.println("경로 " + path);
		  int size=1024*1024*7;
		 
		  DefaultFileRenamePolicy dfr = new  DefaultFileRenamePolicy( );
		  MultipartRequest mr=new MultipartRequest(request,path,size,"UTF-8", dfr);
		
	
		//InsertController.java 단독실행하면 에러발생 guestWrite.jsp연결해서 사용
		int Gsabun = Integer.parseInt(mr.getParameter("sabun"));
		String Guserid=mr.getParameter("userid");
		int Gpwd=Integer.parseInt(mr.getParameter("pwd"));
		String Gfile=mr.getFilesystemName("file");
		String Gcontent=mr.getParameter("content");
		String phone = mr.getParameter("num1")+"-"+mr.getParameter("num2")+"-"+mr.getParameter("num3");
		String addr1 = mr.getParameter("juso1");
		String addr2 = mr.getParameter("juso2");
		String email = mr.getParameter("email");
		
		GuestDTO dto = new GuestDTO();
		GuestSQL sql = new GuestSQL();
		
		dto.setSabun(Gsabun);
		dto.setUserid(Guserid);
		dto.setPwd(Gpwd);
		dto.setFile(Gfile);
		dto.setContent(Gcontent);
		dto.setPhone(phone);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setEmail(email);
		
		int OK=sql.guestInsert1(dto);
		if(OK>0) { 
			System.out.println("SignUp 성공");
			response.sendRedirect("loginAjax.jsp");
			
		}
		
	}//end
	
}//class END












