package net.tis.common;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;//��ü��ȸ, �Ѱ���ȸ

public class Global {
	public Connection CN ; //DB���������� user/pwd��� CN�����ؼ� ���ɾ����
	public Statement ST ; // ������ ���ɾ� ST=CN.createStatement(X);
	public PreparedStatement PST; //������ ���ɾ� PST=CN.preparedStatement(sql);
	public CallableStatement CS;// storedProcedure
	public ResultSet RS; // ��ȸ�Ѱ����� RS=ST.executeQuery(select~),RS.next()
			
	public int Grn;//���ȣ(rownum)	  
	public int Gsabun, Gpay, Ghit,Gpwd;
	public String Gname, Gtitle,Gseasons;
	public Date Gwdate;
	public String Gemail,Gfile,Guserid;
	  
	public int Gdata ; //int data ���
	public int Gtotal;
	public int Atotal;
	public String msg;
	public ArrayList Glist;
}