package com.yedam.member;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			System.out.println("회원 가입되었습니다.");
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
		if(member == null) {
			System.out.println("수강 정보가 없습니다. 수강 신청하세요.");
		}else {
			System.out.println("ID : " + member.getMemberId());
			System.out.println("수강 레벨 : " + member.getLevelName());
			System.out.println("등록일 : " + member.getStartDate());
			System.out.println("등록 기간 : " + member.getDuration() + "개월");
			System.out.println("종료일 : " + member.getEndDate());
			System.out.println("레벨 테스트 신청 : " + member.getTestApply());
			System.out.println("레벨 테스트 승인 : " + member.getTestApprove());
			System.out.println("레벨 테스트 결과 : " + member.getTestResult());
		}
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

	//수강신청 전 수강 등록내역 유무 확인
	public void checkCourse() {
		Member member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
		if(MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId()) != null ) {
			//수강 내역 있음
			Date now = new Date();
			Date endCheck2 = new Date();
			String endCheck = member.getEndDate();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			fm.format(now);
			try {
				endCheck2 = fm.parse(endCheck);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int compare = now.compareTo(endCheck2);
			if(compare > 0 ) {
				//수강 완료 - 종료일 지남 - 재 신청 가능
				System.out.println("수강 완료하여 새 강의 신청이 가능합니다.");
				updateCourse();
			}else {
				//수강 진행 중
				System.out.println("현재 수강 중 입니다.");
				System.out.println(member.getLevelName() + " 레벨, " + member.getDuration() + "개월 과정");
			}
		}else {
			//수강 내역 없음 - 신청 가능
			insertCourse();
		}
	}

	//수강신청 - insert
	public void insertCourse(){
		System.out.println("[ 수 강 신 청 ]");
		System.out.println("▽ 수강 레벨을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		int selectLevel = Integer.parseInt(sc.nextLine());
		if (selectLevel < 1 || selectLevel > 4) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			selectLevel = Integer.parseInt(sc.nextLine());
		}

		System.out.println("▽ 수강 기간을 선택하세요.");
		System.out.println("1. 1개월 | 2. 2개월");
		int selectDuration = Integer.parseInt(sc.nextLine());
		if (selectDuration < 1 || selectDuration > 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			selectDuration = Integer.parseInt(sc.nextLine());
		}

		int result = MemberDAO.getInstance().insertCourse(selectLevel, selectDuration);

		if (result > 0) {
			Member member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
			System.out.println( member.getLevelName() + " 레벨, " + selectDuration + "개월 과정이 신청되었습니다.");
			System.out.println("수강 종료일은 " + member.getEndDate() + "일 입니다.");
		} else {
			System.out.println("수강 신청 실패");
		}
	}

	//새 수강 신청 update
	public void updateCourse() {
		System.out.println("[ 수 강 신 청 ]");
		System.out.println("▽ 수강 레벨을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		int selectLevel = Integer.parseInt(sc.nextLine());
		if (selectLevel < 1 || selectLevel > 4) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			selectLevel = Integer.parseInt(sc.nextLine());
		}

		System.out.println("▽ 수강 기간을 선택하세요.");
		System.out.println("1. 1개월 | 2. 2개월");
		int selectDuration = Integer.parseInt(sc.nextLine());
		if (selectDuration < 1 || selectDuration > 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			selectDuration = Integer.parseInt(sc.nextLine());
		}

		int result = MemberDAO.getInstance().updateCourse(selectLevel, selectDuration);

		if (result > 0) {
			Member member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
			System.out.println( member.getLevelName() + " 레벨, " + selectDuration + "개월 과정이 신청되었습니다.");
			System.out.println("수강 종료일은 " + member.getEndDate() + "일 입니다.");
		} else {
			System.out.println("수강 신청 실패");
		}
	}
	//레벨 테스트 신청
	//수강 2개월 이상 and 종료일 이후 - 신청 가능
	public void testApply() {
		Member member = MemberDAO.getInstance().getCourseInfo(memberInfo.getMemberId());
		if (member == null) {
			System.out.println("수강 정보가 없습니다. 수강 신청하세요.");
			return;
		}
		if(member.getTestApply() != null) {
			System.out.println("이미 신청 되었습니다. 관리자 승인을 기다려주세요.");
		}else {
			Date now = new Date();
			Date endCheck2 = new Date();
			String endCheck = member.getEndDate();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			fm.format(now);
			try {
				endCheck2 = fm.parse(endCheck);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int compare = now.compareTo(endCheck2);
			if((compare > 0) && (member.getDuration() ==2)) {
				//종료일 지남 - 테스트 신청 가능
				System.out.println("레벨 테스트 신청 가능합니다.");
				System.out.println("신청하시겠습니까?");
				System.out.println("1. 신청 | 2. 취소");
				int selectNo = Integer.parseInt(sc.nextLine());
				if(selectNo == 1) {
					int result = MemberDAO.getInstance().testApply(memberInfo.getMemberId());
					if(result > 0 ) {
						System.out.println("레벨 테스트 신청 되었습니다. 관리자 승인을 기다려주세요.");
					}else {
						System.out.println("레벨 테스트 신청 신청 실패");
					}
				}else if(selectNo == 2) {
				}
			}else if((compare < 0) && (member.getDuration() ==2)){
				System.out.println("수강 코스 당 2개월 수강 후 신청 가능합니다. 종료일을 확인하세요.");
				System.out.println("현재 " + member.getDuration() + "개월  과정 수강 중, 종료일 : " + member.getEndDate());
			}else if(member.getDuration() ==1) {
				System.out.println("수강 코스 당 2개월 수강 후 신청 가능합니다. \n(1개월 추가 등록 필요)");
				System.out.println("현재 " + member.getDuration() + "개월  과정 수강 중, 종료일 : " + member.getEndDate());
			}
		}
	}

}

