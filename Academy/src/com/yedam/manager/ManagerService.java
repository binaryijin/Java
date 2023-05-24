package com.yedam.manager;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;

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
			System.out.println("종료일 : " + list.get(i).getEndDate());
			System.out.println("레벨 테스트 신청 대상 : " + list.get(i).getTestTarget());
			System.out.println("레벨 테스트 결과 : " + list.get(i).getTestResult());
		}
	}
	
	//강의별 수강생 조회
	public void getcourseList() {
		System.out.println("[ 강의별 수강생 조회 ]");
		System.out.println("▽과목을 선택하세요.");
		System.out.println("1. Beginner | 2. Basic | 3. Intermediate | 4. Advanced");
		
		int courseMenu = Integer.parseInt(sc.nextLine());
		List<Member> list = ManagerDAO.getInstance().getcourseList(courseMenu);
		
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
			System.out.println("종료일 : " + list.get(i).getEndDate());
			System.out.println("레벨 테스트 신청 대상 : " + list.get(i).getTestTarget());
			System.out.println("레벨 테스트 결과 : " + list.get(i).getTestResult());
		}
	}
	
	//회원 삭제
	public void deleteMember() {
		System.out.println("[ 수강생 삭제 ]");
		System.out.println("ID를 입력하세요. >");
		String id = sc.nextLine();
		int result = ManagerDAO.getInstance().deleteMember(id);
		
		if(result > 0) {
			System.out.println("수강생 삭제 완료");
		}else {
			System.out.println("수강생 삭제 실패");
		}
	}
}
