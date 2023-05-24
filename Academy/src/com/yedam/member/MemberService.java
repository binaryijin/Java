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
		System.out.println("ID > ");
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
	
	//내 정보 조회 - 기본 정보
	public void getMemberInfo() {
		System.out.println("[ 기본 정보 조회 ]");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("ID : " + member.getMemberId());
		System.out.println("PW : " + member.getMemberPw());
		System.out.println("이름 : " + member.getMemberName());
	}
	
	//내 정보 조회 - 수강 정보 조회
	public void getCourseInfo() {
		System.out.println("[ 수강 정보 조회 ]");
		Member member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
		System.out.println("ID : " + member.getMemberId());
		if(member.getLevelId() == 1) {
			System.out.println("수강레벨 : Beginner");
		}else if(member.getLevelId() == 2) {
			System.out.println("수강레벨 : Basic");
		}else if(member.getLevelId() == 3) {
			System.out.println("수강레벨 : Intermediate");
		}else if(member.getLevelId() == 4) {
			System.out.println("수강레벨 : Advanced");
		}
		System.out.println("등록일 : " + member.getStartDate());
		System.out.println("종료일 : " + member.getEndDate());
		System.out.println("레벨 테스트 신청 대상 : " + member.getTestTarget());
		System.out.println("레벨 테스트 결과 : " + member.getTestResult());
	}
	
	//비밀번호 수정
	public void updatePw() {
		System.out.println("[ 비밀번호 수정 ]");
		Member member = new Member();
		String memberPw = "";
		
		System.out.println("본인 확인을 위해 ID를 입력하세요. >");
		String id = sc.nextLine();
		
		if(id.equals(memberInfo.getMemberId())) {
			System.out.println("본인 확인 완료");
			System.out.println("새 비밀번호를 입력하세요. >");
			memberPw = sc.nextLine();
			
			member.setMemberId(id);
			member.setMemberPw(memberPw);
			
			int result = MemberDAO.getInstance().updatePw(member);
			if(result > 0) {
				System.out.println("비밀번호 수정 완료");
			}else {
				System.out.println("비밀번호 수정 실패");
			}
		}else {
			System.out.println("ID가 틀렸습니다.");
			System.out.println("비밀번호 수정 실패");
		}
	}
	
	
	
	
	//수강신청
	public void insertCourse() {
		System.out.println("[ 수 강 신 청 ]");
		System.out.println("▽과목을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		int selectLevel = Integer.parseInt(sc.nextLine());

		System.out.println("▽수강기간을 선택하세요.");
		System.out.println("1. 1개월 | 2. 2개월 | 3. 6개월");
		int selectDuration = Integer.parseInt(sc.nextLine());

		int result = MemberDAO.getInstance().insertCourse(selectLevel, selectDuration);
		
		if (result > 0) {
	        System.out.println("수강 신청 완료");
	    } else {
	        System.out.println("수강 신청 실패");
	    }
	}
}