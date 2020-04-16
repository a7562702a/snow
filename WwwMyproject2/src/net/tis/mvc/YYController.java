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


@WebServlet("/yy.tis")
public class YYController extends HttpServlet {
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
		
		int pay=Integer.parseInt(request.getParameter("pay"));
		String time=request.getParameter("time");
		int sabun=Integer.parseInt(request.getParameter("sabun"));
		String date=request.getParameter("date");
		
		
		GuestDTO dto = new GuestDTO();
		GuestSQL sql = new GuestSQL();
		
		dto.setPay(pay);
		dto.setTime(time);
		dto.setSabun(sabun);
		dto.setDate(date);
		int ok=sql.yyInsert(dto);
		if(ok>0) {
			System.out.println("¼º°ø!");
			response.sendRedirect("yylist.tis");
		}
		
		
	}//end
	
}//class END












