package com.yedam.member;

import java.sql.Date;

public class Member {
//	create table member(
//			member_id varchar2(10) primary key,
//			member_pw varchar2(10),
//			member_name varchar2(10),
//			member_auth char(1));
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAuth;
	
//	member_id varchar2(20) primary Key,
//	lavel_id number(1),
//	start_date date ,
//	end_date date,
//	test_target varchar2(20),
//	test_result varchar2(20),
//	foreign key (member_id) references member(member_id),
//	foreign key (lavel_id) references lavel(lavel_id));
	
	private int lavel_id;
	private Date start_date;
	private Date end_date;
	private String test_target;
	private String test_result;
	
//	lavel_id number(1) primary key,
//	lavel_name varchar2(20));
	
	private int lavelId;
	private String lavelName;
	
//	duration_id number(1) primary key,
//	duration_months number(1) not null);
	
	private int durationId;
	private int durationMonths;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
	public int getLavel_id() {
		return lavel_id;
	}
	public void setLavel_id(int lavel_id) {
		this.lavel_id = lavel_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getTest_target() {
		return test_target;
	}
	public void setTest_target(String test_target) {
		this.test_target = test_target;
	}
	public String getTest_result() {
		return test_result;
	}
	public void setTest_result(String test_result) {
		this.test_result = test_result;
	}
	public int getLavelId() {
		return lavelId;
	}
	public void setLavelId(int lavelId) {
		this.lavelId = lavelId;
	}
	public String getLavelName() {
		return lavelName;
	}
	public void setLavelName(String lavelName) {
		this.lavelName = lavelName;
	}
	public int getDurationId() {
		return durationId;
	}
	public void setDurationId(int durationId) {
		this.durationId = durationId;
	}
	public int getDurationMonths() {
		return durationMonths;
	}
	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}
	
	
}