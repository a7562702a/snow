package net.tis.guest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import net.tis.common.DB;
import net.tis.common.Global;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GuestSQL extends Global {	
   public GuestSQL() {
	 CN = DB.getConnection();
	 if(CN==null) {
	    System.out.println("GuestSQL기본생성자 db연결실패 now!!");
	 }
   }//end

  public int guestInsert(GuestDTO dto) { 
	int ok = 0;  
	try {
	
	 msg="insert into cb_list values(?,?,?,?, sysdate,0, ?,?,?,cb_list_seq.nextval)";
	 PST = CN.prepareStatement(msg);
	 	   PST.setInt(1, dto.getSabun()); //PST.setInt(1, a);
	 	   PST.setString(2, dto.getName()); //PST.setString(2, b);
	 	   PST.setString(3, dto.getSeasons()); //PST.setString(3, c);
	 	   PST.setString(4, dto.getContent());  //PST.setInt(4, d);
	 	   //PST.setInt(5, dto.getHit()); //PST.setString(5, e);
	 	   PST.setInt(5,dto.getSize());
	 	   PST.setString(6,dto.getFile());
	 	   PST.setInt(7, dto.getPay());
	 ok = PST.executeUpdate();
	 System.out.println(ok);
	 if(ok>0) { System.out.println("모델1 GuestDTO매개인자이용 저장성공"); }
	}catch(Exception ex){ System.out.println("e:"+ex);}
	return ok;
  }//end
  
  public int guestInsert1(GuestDTO dto) { //sing up
		int ok = 0;  
		try {
		
		 msg="insert into cbuser values(?,?,?,?, sysdate, ?,?,?,?,?)";
		 PST = CN.prepareStatement(msg);
		 	   PST.setInt(1, dto.getSabun()); 
		 	   PST.setString(2, dto.getUserid()); 
		 	   PST.setInt(3, dto.getPwd()); 
		 	   PST.setString(4, dto.getPhone()); 
		 	   PST.setString(5,dto.getAddr1());
		 	   PST.setString(6,dto.getAddr2());
		 	   PST.setString(7, dto.getEmail());
		 	   PST.setString(8,dto.getFile());
		 	   PST.setInt(9, dto.getSize());
		 ok = PST.executeUpdate();
		 System.out.println(ok);
		 if(ok>0) { System.out.println("Sign up 저장성공"); }
		}catch(Exception ex){ System.out.println("e:"+ex);}
		return ok;
	  }//end
  
  
  public int yyInsert(GuestDTO dto) {//예약
	  int ok=0;
	  try {
		  msg="insert into yylist values(?,?,?,?)";
		  PST=CN.prepareStatement(msg);
		     PST.setInt(1, dto.getSabun());
		     PST.setString(2,dto.getTime());
		     PST.setInt(3,dto.getPay());
		     PST.setString(4,dto.getDate());
		  ok=PST.executeUpdate();
		  if(ok>0) {System.out.println("예약성공!!!!");}   
	  }catch(Exception e) {System.out.println("Error:"+e);}
	  return ok;
  }
  
  public ArrayList<GuestDTO> guestSelect(int start, int end, String sqry) { //페이징X,검색X
	  ArrayList<GuestDTO> list = new ArrayList<GuestDTO>( );
	  //sqry=skey + 
	 try {
	  String a=" select * from ( ";
	  String b=" select rownum rn, a.*,(select count(*) from cb_reply r where r.sabun=a.sabun) as rcnt from "; 
	  String z=" (select * from cb_list " + sqry + ") a ";
	  String c=" ) where rn between "+ start + " and " + end;
	  msg=a+b+z+c;
	  System.out.println(msg);
	  ST = CN.createStatement();
	  RS = ST.executeQuery(msg);
	  while(RS.next()==true) {
		  GuestDTO dto = new GuestDTO(); // while문 안쪽에 있어야 된다 밖에 있으면 마지막 한개만 출력된다.
		  dto.setRn(RS.getInt("rn")); 
		  dto.setSabun(RS.getInt("sabun"));
		  dto.setName(RS.getString("name"));
		  dto.setSeasons(RS.getString("seasons"));
		  dto.setWdate(RS.getDate("wdate"));
		  dto.setHit(RS.getInt("hit"));
		  dto.setRcnt(RS.getInt("rcnt"));
		  dto.setContent(RS.getString("content"));
		  dto.setPay(RS.getInt("pay"));
		  dto.setFile(RS.getString("file1"));
		  list.add(dto);// 필수항목
		  
	  }
	 }catch(Exception e) { }
	 return list;
  }//end
  
  
  public ArrayList<GuestDTO> yylistSelect(int start, int end, String sqry) { //페이징X,검색X
	  ArrayList<GuestDTO> list = new ArrayList<GuestDTO>( );
	  //sqry=skey + 
	 try {
	  String a=" select * from ( ";
	  String b=" select rownum rn, a.*,(select count(*) from cb_reply r where r.sabun=a.sabun) as rcnt from "; 
	  String z=" (select * from yylist " + sqry + ") a ";
	  String c=" ) where rn between "+ start + " and " + end;
	  msg=a+b+z+c;
	  System.out.println(msg);
	  ST = CN.createStatement();
	  RS = ST.executeQuery(msg);
	  while(RS.next()==true) {
		  GuestDTO dto = new GuestDTO(); // while문 안쪽에 있어야 된다 밖에 있으면 마지막 한개만 출력된다.
		  dto.setRn(RS.getInt("rn")); 
		  dto.setSabun(RS.getInt("sabun"));
		  dto.setTime(RS.getString("time"));
		  dto.setDate(RS.getString("wdate"));
		  dto.setRcnt(RS.getInt("rcnt"));
		  dto.setPay(RS.getInt("pay"));
		  list.add(dto);// 필수항목
	  }
	 }catch(Exception e) { }
	 return list;
  }//end
  
  public int guestAlltotal() {
	  int count=0;
	  try {
		  msg="select count(*) as cnt from guest";
		  ST=CN.createStatement();
		  RS=ST.executeQuery(msg);
		  if(RS.next()==true) { count=RS.getInt("cnt"); }
	  } catch (Exception ex) { }
	  return count;
  }
  
  public int guestAlltotal(String sqry) {
	  int count=0;
	  try {
		  msg="select count(*) as cnt from cb_list " + sqry;//select count(*) as cnt from guest " where " + skey + " like '%" + sval + "%' ;
		  ST=CN.createStatement();
		  RS=ST.executeQuery(msg);
		  if(RS.next()==true) { count=RS.getInt("cnt"); }
	  } catch (Exception ex) { }
	  return count;
  } 
  
  public int yylistAlltotal(String sqry) {
	  int count=0;
	  try {
		  msg="select count(*) as cnt from yylist " + sqry;
		  ST=CN.createStatement();
		  RS=ST.executeQuery(msg);
		  if(RS.next()==true) { count=RS.getInt("cnt"); }
	  } catch (Exception ex) { }
	  return count;
  } 
  
  public GuestDTO guestDetail(String data) { //한건 상세출력
	  GuestDTO dto = new GuestDTO(); //dto를 트라이캐치 밖으로빼서 밖에서도 쓰게하자.
	  try {
         msg="select * from cb_list where sabun = " + data ;
         ST=CN.createStatement();
		 RS=ST.executeQuery(msg);
		 if(RS.next()==true) {
			  dto.setNum(RS.getInt("num"));
			  dto.setSabun(RS.getInt("sabun"));
			  dto.setName(RS.getString("name"));
			  dto.setWdate(RS.getDate("wdate"));
			  dto.setPay(RS.getInt("pay"));
			  dto.setFile(RS.getString("file1"));
			  dto.setSeasons(RS.getString("seasons"));
			  dto.setContent(RS.getString("content"));
			  guestHit(data);
		 }
     }catch (Exception e) {}
	  return dto;
  }
  
  public GuestDTO guestDetail1(String data) { //한건 상세출력
	  GuestDTO dto = new GuestDTO(); //dto를 트라이캐치 밖으로빼서 밖에서도 쓰게하자.
	  try {
         msg="select * from cbuser where sabun = " + data ;
         ST=CN.createStatement();
		 RS=ST.executeQuery(msg);
		 System.out.println(msg);
		 if(RS.next()==true) {
			  dto.setSabun(RS.getInt("sabun"));
			  dto.setUserid(RS.getNString("userid"));
			  dto.setPhone(RS.getString("phone"));
			  dto.setWdate(RS.getDate("wdate"));
			  dto.setEmail(RS.getString("email"));
			  dto.setAddr1(RS.getString("address1"));
			  dto.setAddr2(RS.getString("address2"));
			  dto.setFile(RS.getString("file1"));
			  
		 }
     }catch (Exception e) {}
	  return dto;
  }
  
  public int guestHit(String data) {
	  int ghit=0;
	  try {
		  msg="update cb_list set hit=hit+1 where sabun = " + data;
		  ST = CN.createStatement();
		  ST.executeUpdate(msg);
		  
	  }catch (Exception e) {
		
	}return ghit;
  }
	
  public int guestDelete( String my ) { //삭제는 반드시 조건절
  	 int ok=0;
	 try {
		msg="delete from cb_list where sabun = ? " ;
		//msg="delete from guest where sabun = " +  my ; 
		//ST=CN.createStatement( );
		//ok = ST.executeUpdate(msg);
		
		PST = CN.prepareStatement(msg);
			  PST.setString(1, my);
		ok = PST.executeUpdate();
		System.out.println(my +" 데이터 삭제 성공 1월29일 수요일 오후");
	 }catch (Exception e){System.out.println(e);}
	 return ok; 
	}//end
  
  public int guestEdit(GuestDTO dto) {
	  int ok=0;
	 try {
		 msg="update cb_list set name=? , seasons=?, content=?, wdate=sysdate, hit=0 , size1=? , file1=? , pay=?,num=0  where sabun=? ";
		 
		 PST = CN.prepareStatement(msg);
		 PST.setString(1, dto.getName());
		 PST.setString(2, dto.getSeasons());
		 PST.setString(3, dto.getContent());
		 PST.setInt(4, dto.getSize());
		 PST.setString(5,dto.getFile());
		 PST.setInt(6,dto.getPay());
		 PST.setInt(7,dto.getSabun());
		 ok = PST.executeUpdate();
		 System.out.println(ok);
		 if(ok>0) { System.out.println("수정성공"); }
	 }catch(Exception e) {System.out.println("error:"+e);}
	 return ok;
  }


	
}//GuestSQL class END





