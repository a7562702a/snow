package net.tis.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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


@WebServlet("/gedit.tis")
public class EditController extends HttpServlet {
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
		PrintWriter out = response.getWriter(); //out개체생성후 화면출력
		
		  ServletContext context =  this.getServletContext(); 
		  ServletContext application =  this.getServletContext();
		  String path=application.getRealPath("./storage");
		  System.out.println("경로 " + path);//
		  int size=1024*1024*7;
		 
		  DefaultFileRenamePolicy dfr = new  DefaultFileRenamePolicy( );
		  MultipartRequest mr=new MultipartRequest(request,path,size,"UTF-8", dfr);
	
		//EditpreController.java컨트롤뮨서
		
		int Gsabun = Integer.parseInt(mr.getParameter("sabun"));
		String Gname = mr.getParameter("name");
		int Gpay = Integer.parseInt(mr.getParameter("pay"));
		String Gseasons=mr.getParameter("seasons");
		String Gcontent=mr.getParameter("content");
		String Gfile=mr.getFilesystemName("file");
		
		GuestSQL sql = new GuestSQL( );
		GuestDTO dto = new GuestDTO( );
		dto.setSabun(Gsabun);
		dto.setName(Gname);
		dto.setContent(Gcontent);
		dto.setPay(Gpay);
		dto.setSeasons(Gseasons);
		dto.setFile(Gfile);
		sql.guestEdit(dto);
		response.sendRedirect("glist.tis");
		
		
	}//end
	
}//class END












