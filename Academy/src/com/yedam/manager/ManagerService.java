package com.yedam.manager;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;

public class ManagerService {
	Scanner sc = new Scanner(System.in);
	
	//전체 수강생 정보 조회
	public void getMemberList() {
		List<Member> list = ManagerDAO.getInstance().getMemberList();
		System.out.println("[ 전체 수강생 조회 ]");
		for(int i=0; i<list.size(); i++) {
			System.out.println("=========================");
			System.out.println("ID : " + list.get(i).getMemberId());
			System.out.println("이름 : " + list.get(i).getMemberName());
			
			if(list.get(i).getLevelId() == 1) {
				System.out.println("수강 레벨 : Beginner");
			}else if(list.get(i).getLevelId() == 2) {
				System.out.println("수강 레벨 : Basic");
			}else if(list.get(i).getLevelId() == 3) {
				System.out.println("수강 레벨 : Intermediate");
			}else if(list.get(i).getLevelId() == 4) {
				System.out.println("수강 레벨 : Advanced");
			}
			System.out.println("등록일 : " + list.get(i).getStartDate());
			System.out.println("등록 기간 : " + list.get(i).getDuration() + "개월");
			System.out.println("종료일 : " + list.get(i).getEndDate());
			System.out.println("레벨 테스트 신청 대상 : " + list.get(i).getTestTarget());
			System.out.println("레벨 테스트 결과 : " + list.get(i).getTestResult());
		}
	}
	
	//강의별 수강생 조회
	public void getcourseList() {
		System.out.println("[ 강의별 수강생 조회 ]");
		System.out.println("▽수강 레벨을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		
		int courseMenu = Integer.parseInt(sc.nextLine());
		List<Member> list = ManagerDAO.getInstance().getcourseList(courseMenu);
		if(list.size() > 0) {
			for(int i=0; i<list.size(); i++) {
				System.out.println("=========================");

				if(list.get(i).getLevelId() == 1) {
					System.out.println("수강 레벨 : Beginner");
				}else if(list.get(i).getLevelId() == 2) {
					System.out.println("수강 레벨 : Basic");
				}else if(list.get(i).getLevelId() == 3) {
					System.out.println("수강 레벨 : Intermediate");
				}else if(list.get(i).getLevelId() == 4) {
					System.out.println("수강 레벨 : Advanced");
				}
				System.out.println("ID : " + list.get(i).getMemberId());
				System.out.println("이름 : " + list.get(i).getMemberName());
				System.out.println("등록일 : " + list.get(i).getStartDate());
				System.out.println("등록 기간 : " + list.get(i).getDuration() + "개월");
				System.out.println("종료일 : " + list.get(i).getEndDate());
				System.out.println("레벨 테스트 신청 대상 : " + list.get(i).getTestTarget());
				System.out.println("레벨 테스트 결과 : " + list.get(i).getTestResult());
			}
		}else {
			System.out.println("해당 레벨의 수강생이 없습니다.");
		}
	}
	
	//회원 삭제
	//부모 테이블(member) 삭제 시, 자식 테이블도 같이 삭제됨(ON DELETE CASCADE)
	public void deleteMember() {
		System.out.println("[ 수강생 삭제 ]");
		System.out.println("ID를 입력하세요. >");
		String id = sc.nextLine();

		int result = 0;

		Member member = MemberDAO.getInstance().login(id);
		if(member == null) {
			System.out.println("존재하지 않는 ID 입니다.");
		}else {
			System.out.println("ID " + id + " 를 삭제하시겠습니까?");
			System.out.println("1. 삭제 | 2. 취소");
			int selectNo = Integer.parseInt(sc.nextLine());
			if(selectNo == 1) {
				result = ManagerDAO.getInstance().deleteMember(id);
			}else if(selectNo == 2) {
			}
		}
		if(result > 0) {
			System.out.println("수강생 ID " + id + " 가 삭제되었습니다.");
		}else {
			System.out.println("수강생 삭제 실패");
		}
	}
	
	
}
