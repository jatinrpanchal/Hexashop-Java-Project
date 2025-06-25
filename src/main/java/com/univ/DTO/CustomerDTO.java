package com.univ.DTO;

public class CustomerDTO {
int cid,status;
long mob;
String cname,cadd,email,unm,pw;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public long getMob() {
	return mob;
}
public void setMob(long mob) {
	this.mob = mob;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCadd() {
	return cadd;
}
public void setCadd(String cadd) {
	this.cadd = cadd;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUnm() {
	return unm;
}
public void setUnm(String unm) {
	this.unm = unm;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}


}
