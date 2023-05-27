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
//	start_date date,
//	duration number(1),
//	test_target varchar2(20),
//	test_result varchar2(20),

	
	private int levelId;
	private String levelName;
	private Date startDate;
	private int duration;
	private String testApply;
	private String testResult;
	
	
	
	private String endDate;
	
	private String testApprove;
	
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getTestApprove() {
		return testApprove;
	}
	public void setTestApprove(String testApprove) {
		this.testApprove = testApprove;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
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
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTestApply() {
		return testApply;
	}
	public void setTestApply(String testTarget) {
		this.testApply = testTarget;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	

	
	
	
}