package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;


public class Application {
	int selectNo = 0;
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public Application(){
		run();
	}
	
	private void run() {
		while(selectNo !=3 ) {
			if(MemberService.memberInfo == null) {
				System.out.println("============================");
				System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
				System.out.println("============================");
				System.out.println("입력 > ");
				selectNo = Integer.parseInt(sc.nextLine());

				switch (selectNo) {
				case 1:
					ms.login();
					break;
				case 2:
					ms.insertMember();
					break;
				case 3:
					System.out.println("프로그램 종료");
					break;
				}
			}
			if(MemberService.memberInfo != null) {
				//로그인한 정보 (학생 S)/ (관리자 M)
				if(MemberService.memberInfo.getMemberAuth().equals("S")) {
					new MemberApp();
				}else if(MemberService.memberInfo.getMemberAuth().equals("M")) {
				}
			}
		}



//			menu();
//			switch (selectNo) {
//			case 1:
//				new MemberApp();
//				break;
//			case 2:
//				break;
//			case 3:
//				System.out.println("end of program");
//				break;
//	
//			}
//		}
	}
	
//	private void menu() {
//		System.out.println("========================");
//		System.out.println("1. 학생 | 2. 학원 | 3. 종료");
//		System.out.println("========================");
//		System.out.println("입력 > ");
//		selectNo = Integer.parseInt(sc.nextLine());
//	}
	
}
