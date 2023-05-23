package com.yedam.member;

import java.util.Scanner;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void login() {
		System.out.println("[ 로 그 인 ]");
		System.out.println("ID > ");
		String id = sc.nextLine();
		
		System.out.println("PW > ");
		String pw = sc.nextLine();
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("로그인 성공");
				memberInfo = member;
			}else {
				System.out.println("비밀번호 불일치");
			}
		}else {
			System.out.println("아이디 불일치");
		}
	}
	
	//회원가입
	public void insertMember() {
		Member member = new Member();
		
		System.out.println("[ 회 원 가 입 ]");	
		System.out.println("ID>");
		member.setMemberId(sc.nextLine());
//		String id = "";
//		while(true) {
//			System.out.println("ID>");
//			id = sc.nextLine();
//			member = MemberDAO.getInstance().login(id);
//			if(member != null) {
//				System.out.println("존재하는 ID 입니다.");
//			}else if(member == null) {
//				System.out.println("사용 가능한 ID 입니다.");
//				break;
//			}
//		}
		System.out.println("PW > ");
		member.setMemberPw(sc.nextLine());
		
		System.out.println("NAME > ");
		member.setMemberName(sc.nextLine());
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		if(result > 0) {
			System.out.println("회원 가입 성공");
		}else {
			System.out.println("회원 가입 실패");
		}
	}
	
	//정보 조회
	public void getMemberInfo() {
		System.out.println("[ 기본 정보 조회 ]");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("ID : " + member.getMemberId());
		System.out.println("PW : " + member.getMemberPw());
		System.out.println("NAME : " + member.getMemberName());
	}
	
	//수강신청
	public void insertCourse() {
		System.out.println("[ 수 강 신 청 ]");
		System.out.println("과목을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		int selectLevel = sc.nextInt();

		System.out.println("수강기간을 선택하세요.");
		System.out.println("1. 1개월 | 2. 2개월 | 3. 6개월");
		int selectDuration = sc.nextInt();

		Member member = new Member();
		
		int result = MemberDAO.getInstance().insertCourse(member, selectLevel, selectDuration);
		
		if (result > 0) {
	        System.out.println("수강 신청 완료");
	    } else {
	        System.out.println("수강 신청 실패");
	    }
	}
}