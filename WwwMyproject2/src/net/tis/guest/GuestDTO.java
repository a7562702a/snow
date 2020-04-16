package net.tis.guest;

//DTO=VO=Bean=도메인(domain)= ~.jsp/~.java, ~.java/~.java, ~.java/~.xml
public class GuestDTO { //DTO=data transfer object VO=value object=도메인=Domain
  private int sabun,pwd;
  private String name,userid,phone,addr1,addr2;
  private String title,seasons,time,date;

private java.util.Date wdate;
  private int pay;
  private int hit,size;
  private String email,content,file;

private int rn ; 
  private int count ;
  private String skey, sval;
  private int rcnt,num;
   
    //오.버=>source => Generate Getters and Setters...=> select All
  
  
  
  public String getFile() {
  	return file;
  }
  public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getPwd() {
	return pwd;
}
public void setPwd(int pwd) {
	this.pwd = pwd;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddr1() {
	return addr1;
}
public void setAddr1(String addr1) {
	this.addr1 = addr1;
}
public String getAddr2() {
	return addr2;
}
public void setAddr2(String addr2) {
	this.addr2 = addr2;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public void setFile(String file) {
  	this.file = file;
  }
  public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
  
  public String getSeasons() {
	return seasons;
}
public void setSeasons(String seasons) {
	this.seasons = seasons;
}

	public int getCount() { return count;}
    public void setCount(int count) { this.count = count; }
	
    public int getRcnt() {return rcnt;} //댓글갯수
    public void setRcnt(int rcnt) {this.rcnt = rcnt;}
	public int getSabun() {	return sabun;}
	public void setSabun(int sabun) {	this.sabun = sabun;}
	public String getName() {	return name;}
	public void setName(String name) {this.name = name;}
	public java.util.Date getWdate() {return wdate;}
	public void setWdate(java.util.Date wdate) {this.wdate = wdate;}
	public int getPay() {return pay;}
	public void setPay(int pay) {this.pay = pay;}
	public int getHit() {return hit;}
	public void setHit(int hit) {this.hit = hit;}
	
	public String getTitle() {return title;	}
	public void setTitle(String title) {this.title = title;	}
	public String getEmail() {	return email;		}
	public void setEmail(String email) {this.email = email;	}
	public int getRn() {return rn;		}
	public void setRn(int rn) {	this.rn = rn;		}	
	  
  	public String getSkey() {return skey;}
    public void setSkey(String skey) {this.skey = skey;}
    public String getSval() {return sval;}
    public void setSval(String sval) {this.sval = sval;}
}//class END
