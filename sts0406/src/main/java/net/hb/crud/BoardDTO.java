package net.hb.crud;

import org.springframework.web.multipart.MultipartFile;


public class BoardDTO {
  private int hobby_idx;
  private String name,title,content,gender,hobby;
  private String img_file_name;
  private MultipartFile upload_f;
  private int rn;
  private int rcnt;
  
  private int sabun,hit,pay;
  private java.util.Date wdate;
  private String email;
  private int rrn, start, end;  //���ȣ rrn
  private String skey, sval;
  

  
public int getRrn() {
	return rrn;
}
public void setRrn(int rrn) {
	this.rrn = rrn;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}
public String getSkey() {
	return skey;
}
public void setSkey(String skey) {
	this.skey = skey;
}
public String getSval() {
	return sval;
}
public void setSval(String sval) {
	this.sval = sval;
}
public MultipartFile getUpload_f() {
	return upload_f;
}
public void setUpload_f(MultipartFile upload_f) {
	this.upload_f = upload_f;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getSabun() {
	return sabun;
}
public void setSabun(int sabun) {
	this.sabun = sabun;
}
public int getHit() {
	return hit;
}
public void setHit(int hit) {
	this.hit = hit;
}
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}
public java.util.Date getWdate() {
	return wdate;
}
public void setWdate(java.util.Date wdate) {
	this.wdate = wdate;
}
public int getHobby_idx() {
	return hobby_idx;
}
public void setHobby_idx(int hobby_idx) {
	this.hobby_idx = hobby_idx;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getImg_file_name() {
	return img_file_name;
}
public void setImg_file_name(String img_file_name) {
	this.img_file_name = img_file_name;
}
public int getRn() {
	return rn;
}
public void setRn(int rn) {
	this.rn = rn;
}
public int getRcnt() {
	return rcnt;
}
public void setRcnt(int rcnt) {
	this.rcnt = rcnt;
}
  
  
}//class end
