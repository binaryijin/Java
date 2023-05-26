package com.yedam.exe;

import java.util.Scanner;

import com.yedam.manager.ManagerService;
import com.yedam.member.MemberService;

public class ManagerApp {
	Scanner sc = new Scanner(System.in);
	ManagerService mngs = new ManagerService();
	
	public ManagerApp() {
		ManagerRun();
	}

	private void ManagerRun() {
		boolean run = true;

		while(run) {
			ManagerMenu();
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch (selectNo) {
			case 1:
				System.out.println("==================================================");
				System.out.println("1. 전체 수강생 정보 조회 | 2. 강의별 수강생 조회 | 3. 뒤로 가기");
				System.out.println("==================================================");
				System.out.println("입력 >");
				String menu = sc.nextLine();
				if(menu.equals("1")) {
					mngs.getMemberList();
				}else if(menu.equals("2")) {
					mngs.getcourseList();
				}else if(menu.equals("3")) {
					break;
				}
				break;
			case 2:
				System.out.println("==================================================");
				System.out.println("1. 레벨 테스트 승인 | 2. 레벨 테스트 결과 입력 | 3. 뒤로 가기");
				System.out.println("==================================================");
				System.out.println("입력 >");
				menu = sc.nextLine();
				if(menu.equals("1")) {
					mngs.getTestApply();
				}else if(menu.equals("2")) {
				}else if(menu.equals("3")) {
					break;
				}
				break;
			case 3:
				mngs.deleteMember();
				break;
			case 4:
				run = false;
				MemberService.memberInfo = null;
				System.out.println("로그아웃 되었습니다.");
				break;
			}
		}
	}
	
	private void ManagerMenu() {
		System.out.println("=======================================================");
		System.out.println("관리자 모드");
		System.out.println("-------------------------------------------------------");
		System.out.println("1. 수강생 정보 조회 | 2. 레벨 테스트 관리  | 3. 수강생 삭제 | 4. 종료");
		System.out.println("=======================================================");
		System.out.println("입력 > ");
	}
}
