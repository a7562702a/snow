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


@WebServlet("/greplyList.tis")
public class GuestReplyList extends HttpServlet {
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
		
		ReplyDTO rdto=new ReplyDTO();
		ReplySQL rsql=new ReplySQL();
		int rsabun=Integer.parseInt(request.getParameter("Gidx"));
		System.out.println("GuestRepalList.jsp rsabun="+rsabun);
		//int rnum=Integer.parseInt(request.getParameter("Gnum"));
		int Rtotal=rsql.dbReplyCount(rsabun);	
		
		String flag=request.getParameter("flag");
		if(flag==null||flag=="") {
			ArrayList<ReplyDTO> rLG=rsql.dbReplySelect(rsabun);
			request.setAttribute("rLG",rLG);
			request.setAttribute("rsabun",rsabun);
			//request.setAttribute("rnum",rnum);
			request.setAttribute("Rtotal",Rtotal);
			
			RequestDispatcher dis=request.getRequestDispatcher("cbdetail.jsp");
			dis.forward(request,response);
		}else {
			
		}
		
	}//end
	
}//class END













