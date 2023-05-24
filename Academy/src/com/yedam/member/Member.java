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
//	level_id number(1),
//	start_date date,
//	end_date date,
//	test_target varchar2(20),
//	test_result varchar2(20),
//	foreign key (member_id) references member(member_id),
//	foreign key (level_id) references course_level(level_id));

	
	private int levelId;
	private Date startDate;
	private Date endDate;
	private String testTarget;
	private String testResult;
	
//	level_id number(1) primary key,
//	level_name varchar2(20))
	
	private String levelName;
	
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTestTarget() {
		return testTarget;
	}
	public void setTestTarget(String testTarget) {
		this.testTarget = testTarget;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
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