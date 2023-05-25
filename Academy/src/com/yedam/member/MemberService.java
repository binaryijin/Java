package com.yedam.member;

import java.util.Scanner;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void login() {
		while(true) {
			System.out.println("[ 로 그 인 ]");
			System.out.println("ID > ");
			String id = sc.nextLine();

			Member member = MemberDAO.getInstance().login(id);

			if(member == null) {
				System.out.println("아이디가 존재하지 않습니다. \n다시 입력하세요.");
			}else {
				System.out.println("PW > ");
				String pw = sc.nextLine();
				if(member.getMemberPw().equals(pw)) {
					System.out.println("로그인되었습니다.");
					memberInfo = member;
					break;
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		}
	}
	
	//회원가입
//	public void insertMember() {
//		Member member = new Member();
//		
//		System.out.println("[ 회 원 가 입 ]");	
//		System.out.println("ID > ");
//		member.setMemberId(sc.nextLine());
////		String id = "";
////		while(true) {
////			System.out.println("ID>");
////			id = sc.nextLine();
////			member = MemberDAO.getInstance().login(id);
////			if(member != null) {
////				System.out.println("존재하는 ID 입니다.");
////			}else if(member == null) {
////				System.out.println("사용 가능한 ID 입니다.");
////				break;
////			}
////		}
//		System.out.println("PW > ");
//		member.setMemberPw(sc.nextLine());
//		
//		System.out.println("NAME > ");
//		member.setMemberName(sc.nextLine());
//		
//		int result = MemberDAO.getInstance().insertMember(member);
//		
//		if(result > 0) {
//			System.out.println("회원 가입 성공");
//		}else {
//			System.out.println("회원 가입 실패");
//		}
//	}
	//회원가입 - 기본정보
	public void insertMember() {
		System.out.println("[ 회 원 가 입 ]");	
		String id = "";
		while(true) {
			System.out.println("ID>");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member != null) {
				System.out.println("존재하는 ID 입니다.");
			}else if(member == null) {
				System.out.println("사용 가능한 ID 입니다.");
				break;
			}
		}
		System.out.println("PW > ");
		String pw = sc.nextLine();
		
		System.out.println("NAME > ");
		String name = sc.nextLine();

		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		if(result > 0) {
			System.out.println("회원 가입 되었습니다.");
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
		System.out.println("등록 기간 : " + member.getDuration() + "개월");
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
				System.out.println("비밀번호가 수정되었습니다.");
			}else {
				System.out.println("비밀번호 수정 실패");
			}
		}else {
			System.out.println("ID가 틀렸습니다.");
			System.out.println("비밀번호 수정 실패");
		}
	}
	
	//레벨 테스트 신청 미완성!@!@!!!@@
//	public void test() {
//		Member member = MemberDAO.getInstance().end(memberInfo.getMemberId());
//		Date now = new Date();
//		Date end2 = new Date();
//		
//		String end = member.getEndDate();
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");
//		try {
//			end2 = fm.parse(end);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		int compare = now.compareTo(end2);
//		if(compare > 0 ) {
//			System.out.println("date>today");
//			System.out.println("레벨 테스트 신청 가능 날짜는 " + member.getEndDate() + " 이후 입니다.");
//		}else if(compare <= 0) {
//			System.out.println("레벨 테스트 신청 가능 합니다.");
//		}
//		int compare = date.compareTo(today); 
//		 
//		//조건문
////		if(compare > 0) {
////		  System.out.println("date가 today보다 큽니다.(date > today)");
////		}else if(compare < 0) {
////		  System.out.println("today가 date보다 큽니다.(date < today)");
////		}else {
////		  System.out.println("today와 date가 같습니다.(date = today)");
////		}
//	}
	
	
	//수강 신청 - 유무 확인, 신청
	public void insertCourse() {
		Member member = MemberDAO.getInstance().checkCourse(memberInfo.getMemberId());
		if(MemberDAO.getInstance().checkCourse(memberInfo.getMemberId()) != null ) {
			
			System.out.println("이미 수강 중 입니다.");
			
			//1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced
			if(member.getLevelId() == 1) {
				System.out.println("▷ 현재 Beginner 레벨, " + member.getDuration() + "개월 과정");
			}else if (member.getLevelId() == 2){
				System.out.println("▷ 현재 Basic 레벨, " + member.getDuration() + "개월 과정");
			}else if (member.getLevelId() == 3){
				System.out.println("▷ 현재 Intermediate 레벨, " + member.getDuration() + "개월 과정");
			}else if (member.getLevelId() == 4){
				System.out.println("▷ 현재 Advanced 레벨, " + member.getDuration() + "개월 과정");
			}
		}else {
			System.out.println("[ 수 강 신 청 ]");
			System.out.println("▽ 수강 레벨을 선택하세요.");
			System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
			int selectLevel = Integer.parseInt(sc.nextLine());

			System.out.println("▽ 수강 기간을 선택하세요.");
			System.out.println("1. 1개월 | 2. 2개월 | 3. 3개월");
			int selectDuration = Integer.parseInt(sc.nextLine());

			int result = MemberDAO.getInstance().insertCourse(selectLevel, selectDuration);
			
			if (result > 0) {
				if(selectLevel == 1) {
					System.out.print("▷ Beginner");
				}else if (selectLevel == 2){
					System.out.print("▷ Basic");
				}else if (selectLevel == 3){
					System.out.print("▷ Intermediate");
				}else if (selectLevel == 4){
					System.out.print("▷ Advanced");
				}
				
				System.out.println(" 레벨, " + selectDuration + "개월 과정이 신청되었습니다.");
				member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
				System.out.println("수강 종료일은 " + member.getEndDate() + "일 입니다.");
			} else {
				System.out.println("수강 신청 실패");
			}
			
//			https://developer-talk.tistory.com/409
			
			
			
//			if (result > 0) {
//				if(selectLevel == 1) {
//					System.out.println("▷ Beginner 레벨, " + selectDuration + "개월 과정 신청되었습니다.");
//				}else if (selectLevel == 2){
//					System.out.println("▷ Basic 레벨, " + selectDuration + "개월 과정 신청되었습니다.");
//				}else if (selectLevel == 3){
//					System.out.println("▷ Intermediate 레벨, " + selectDuration + "개월 과정 신청되었습니다.");
//				}else if (selectLevel == 4){
//					System.out.println("▷ Advanced 레벨, " + selectDuration + "개월 과정 신청되었습니다.");
//				}
//			} else {
//				System.out.println("수강 신청 실패");
//			}
		}
	}
}
	
	

		
		
		
		
		
//		Date date = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		
//		cal.add(Calendar.MONTH, member.getDuration());
//		System.out.println(cal);
		
		
//		Date d = new Date ( );
//		Calendar c = Calendar.getInstance ( );
//		c.setTime ( d );
		
		
		
		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(member.getStartDate());
//		cal.add(Calendar.MONTH, member.getDuration());
//		System.out.println(cal);
	