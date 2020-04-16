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

@WebServlet("/glist.tis")
public class ListController extends HttpServlet {
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
		
		//예전 guestList.jsp에서 변수복붙
		 String pnum;
		 int pageNUM, pagecount;
		 int start, end; 
		 int startpage, endpage;  
		 int temp;
		 
		 String sqry="";
		 String skey="", sval="";
		 String returnpage=""; 
		 String AA="", BB="";
		 int Rnumber ; //역순으로 행번호 출력
		 
		 pnum = request.getParameter("pageNum"); //<a href=guestList.jsp?pageNum=i>[i]</a>
		 if(pnum==null || pnum=="" || pnum.equals("")){ pnum="1";}
		 pageNUM=Integer.parseInt(pnum);
		 
		 skey=request.getParameter("keyfield");
		 sval=request.getParameter("keyword");
		 if(skey==null || sval==null || skey=="" || sval=="") {
			 sqry="where name like '%%' ";
			 skey="";
			 sval="";
		 }else {
			 sqry=" where " + skey + " like '%" + sval + "%' ";
		 }
		 
		 returnpage = "&keyfield=" + skey + "&keyword="+sval;
		 
		 if(skey.equals("name")) {AA=skey;}
		 else if(sval.equals("seasons")) {BB=sval;}
		
		 start = (pageNUM-1)*10+1 ; //[24클릭]  231 시작행 
		 end = (pageNUM*10);  //[24클릭] 240 끝행
		 
		//JSTL실습전에 ListController.java서블릿자바문서생성만
		GuestSQL sql = new GuestSQL( );
		GuestDTO dto = new GuestDTO( );
		int Atotal = sql.guestAlltotal(); //전체데이타갯수
		int Gtotal = sql.guestAlltotal(sqry); //검색데이타갯수62건 검색레코드갯수 name필드 b
		//LG = sql.guestSelect(start, end, sqry);
		
		if(Gtotal%10==0){ pagecount=Gtotal/10; }
		else{ pagecount=(Gtotal/10)+1; }
		
		temp=(pageNUM-1)%10;  //3
		startpage=pageNUM-temp; //21
		endpage=startpage+9;  //30
		if(endpage > pagecount){ endpage=pagecount;}
		
		//처음원본 ArrayList<GuestDTO> LG = sql.guestSelect(); 
		ArrayList<GuestDTO> LG = sql.guestSelect(start,end,sqry);  
		
		
		
		request.setAttribute("startpage",startpage);
		request.setAttribute("endpage",endpage);
		request.setAttribute("pagecount",pagecount);
		request.setAttribute("pageNUM",pageNUM);
		request.setAttribute("returnpage",returnpage);
		request.setAttribute("Gtotal",Gtotal);
		
//		request.setAttribute("AA",AA);
//		request.setAttribute("BB",BB);
		request.setAttribute("sqry",sqry);
		request.setAttribute("skey",skey);
		request.setAttribute("sval",sval);
		request.setAttribute("LG", LG);
		RequestDispatcher dis=request.getRequestDispatcher("cblist.jsp");
		dis.forward(request,response);
		
	}//end
	
}//class END












