package com.yedam.member;

import java.sql.Date;

public class Member {
//	create table member(
//			member_id varchar2(10) primary key,
//			member_pw varchar2(10),
//			member_name varchar2(10),
//			member_phone varchar2(13),
//			member_auth char(1));
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String MemberAuth;
	
//	member_id varchar2(10) references member(member_id),
//	course_level varchar2(10),
//	courseinfo_start date,
//	courseinfo_end date,
//	courseinfo_test varchar2(10),
//	courseinfo_result varchar2(10)
	
	private String course_level;
	private Date courseinfo_start;
	private Date courseinfo_end;
	private String course_test;
	private String courseinfo_result;
	
	
	public String getCourse_level() {
		return course_level;
	}
	public void setCourse_level(String course_level) {
		this.course_level = course_level;
	}
	public Date getCourseinfo_start() {
		return courseinfo_start;
	}
	public void setCourseinfo_start(Date courseinfo_start) {
		this.courseinfo_start = courseinfo_start;
	}
	public Date getCourseinfo_end() {
		return courseinfo_end;
	}
	public void setCourseinfo_end(Date courseinfo_end) {
		this.courseinfo_end = courseinfo_end;
	}
	public String getCourse_test() {
		return course_test;
	}
	public void setCourse_test(String course_test) {
		this.course_test = course_test;
	}
	public String getCourseinfo_result() {
		return courseinfo_result;
	}
	public void setCourseinfo_result(String courseinfo_result) {
		this.courseinfo_result = courseinfo_result;
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
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAuth() {
		return MemberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		MemberAuth = memberAuth;
	}
	
	
}
