package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;

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


@WebServlet("/ginsert.tis")
public class InsertController extends HttpServlet {
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
		
		//파일업로드다운로드 532페이지 참고 MultiPartRequest 533페이지 38라인
		//guest테이블은 현재 파일업로드없으니까 MultipartRequest 필요엄써
		ServletContext context =  this.getServletContext(); //533페이지
		ServletContext application =  this.getServletContext();
		//DefaultFileRenamePolicy dfp = new DefaultFileRenamePolicy();
		//MultipartRequest mr = new MultipartRequest(request, "디렉토리", 1024, "UTF-8", dfp);
		
		  String path=application.getRealPath("./storage");
		  System.out.println("경로 " + path);
		  int size=1024*1024*7;
		 
		  DefaultFileRenamePolicy dfr = new  DefaultFileRenamePolicy( );
		  MultipartRequest mr=new MultipartRequest(request,path,size,"UTF-8", dfr);
		
	
		//InsertController.java 단독실행하면 에러발생 guestWrite.jsp연결해서 사용
		int Gsabun = Integer.parseInt(mr.getParameter("sabun"));
		String Gname = mr.getParameter("name");
		String Gseasons = mr.getParameter("seasons");
		int Gpay = Integer.parseInt(mr.getParameter("pay"));
		String Gfile=mr.getFilesystemName("file");
		String Gcontent=mr.getParameter("content");
		
//		out.println("InsertController.java자바서블릿문서");
//		out.println(" 넘어온사번 : " + Gsabun);
//		out.println(" 넘어온이름 : " + Gname);
//		out.println(" 넘어온제목 : " + Gtitle);
//		out.println(" 넘어온급여 : " + Gpay);
//		out.println(" 넘어온메일 : " + Gemail +"<br>");
		
		GuestDTO dto = new GuestDTO();
		GuestSQL sql = new GuestSQL();
		//모델1문서접근=DB처리쿼리문=비지니스로직=CRUD처리단
		//dto의 setXXX(매개인자) => sql.guestInsert(dto)
		dto.setSabun(Gsabun);
		dto.setName(Gname);
		dto.setSeasons(Gseasons);
		dto.setContent(Gcontent);
		//dto.setSize(size);
		dto.setFile(Gfile);
		dto.setPay(Gpay);
		//dto.setEmail(Gemail);
		int OK=sql.guestInsert(dto);
		if(OK>0) { 
			System.out.println("InsertController문서 저장성공");
			response.sendRedirect("yylist.tis");
		}
		
	}//end
	
}//class END












