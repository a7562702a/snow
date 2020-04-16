package net.tis.common;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;//전체조회, 한건조회

public class Global {
	public Connection CN ; //DB서버정보및 user/pwd기억 CN참조해서 명령어생성
	public Statement ST ; // 정적인 명령어 ST=CN.createStatement(X);
	public PreparedStatement PST; //동적인 명령어 PST=CN.preparedStatement(sql);
	public CallableStatement CS;// storedProcedure
	public ResultSet RS; // 조회한결과기억 RS=ST.executeQuery(select~),RS.next()
			
	public int Grn;//행번호(rownum)	  
	public int Gsabun, Gpay, Ghit,Gpwd;
	public String Gname, Gtitle,Gseasons;
	public Date Gwdate;
	public String Gemail,Gfile,Guserid;
	  
	public int Gdata ; //int data 대신
	public int Gtotal;
	public int Atotal;
	public String msg;
	public ArrayList Glist;
}
