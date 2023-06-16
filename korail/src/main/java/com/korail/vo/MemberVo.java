package com.korail.vo;

public class MemberVo {
	String id, pass, name, userEmail1, userEmail2, tel, phonenumber1, phonenumber2, phonenumber3 , year , month, date,
	gender;
	public String getPhonenumber1() {
		return phonenumber1;
	}
	public void setPhonenumber1(String phonenumber1) {
		this.phonenumber1 = phonenumber1;
	}
	public String getPhonenumber2() {
		return phonenumber2;
	}
	public void setPhonenumber2(String phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}
	public String getPhonenumber3() {
		return phonenumber3;
	}
	public void setPhonenumber3(String phonenumber3) {
		this.phonenumber3 = phonenumber3;
	}
	int rno;
	String mid, email , pnumber, birth , mdate,pagename,seatNum,ticketQty;
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getTicketQty() {
		return ticketQty;
	}
	public void setTicketQty(String ticketQty) {
		this.ticketQty = ticketQty;
	}
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserEmail1() {
		return userEmail1;
	}
	public void setUserEmail1(String userEmail1) {
		this.userEmail1 = userEmail1;
	}
	public String getUserEmail2() {
		return userEmail2;
	}
	public void setUserEmail2(String userEmail2) {
		this.userEmail2 = userEmail2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getEmail() {
		if(userEmail1 != null) {
			email = userEmail1 +"@" + userEmail2;
		}
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnumber() {
		if(phonenumber1 != null) {
			pnumber = phonenumber1 + phonenumber2 + phonenumber3;
		}
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

}
