package com.korail.vo;

public class CardinfoVo {
	String cardnum,recognizenum,birthday,cardcomp,cardNum1,cardNum2,cardNum3,cardNum4,cardMonth,cardYear,cardPw;
	
	
	public String getCardNum1() {
		return cardNum1;
	}

	public void setCardNum1(String cardNum1) {
		this.cardNum1 = cardNum1;
	}

	public String getCardNum2() {
		return cardNum2;
	}

	public void setCardNum2(String cardNum2) {
		this.cardNum2 = cardNum2;
	}

	public String getCardNum3() {
		return cardNum3;
	}

	public void setCardNum3(String cardNum3) {
		this.cardNum3 = cardNum3;
	}

	public String getCardNum4() {
		return cardNum4;
	}

	public void setCardNum4(String cardNum4) {
		this.cardNum4 = cardNum4;
	}

	public String getCardnum() {
		if(cardNum1 != null) {
			cardnum = cardNum1 + "-"+ cardNum2 +"-"+ cardNum3 + "-" + cardNum4;
		}
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getRecognizenum() {
		return recognizenum;
	}

	public void setRecognizenum(String recognizenum) {
		this.recognizenum = recognizenum;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCardcomp() {
		return cardcomp;
	}

	public void setCardcomp(String cardcomp) {
		this.cardcomp = cardcomp;
	}
	
	
}
