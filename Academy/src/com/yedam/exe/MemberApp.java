package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public MemberApp() {
		MemberRun();
	}
	
	private void MemberRun() {
		boolean run = true;
		
		while(run) {
			Membermenu();
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch (selectNo) {
			case 1:
				System.out.println("======================");
				System.out.println("1. 기본 정보 | 2. 수강 정보");
				System.out.println("======================");
				System.out.println("입력 >");
				String menu = sc.nextLine();
				if(menu.equals("1")) {
					ms.getMemberInfo();
				}else if(menu.equals("2")) {
					
				}
				break;
			case 2:
				break;
			case 3:
				System.out.println("===========================");
				System.out.println("1. 수강 신청 | 2. 레벨 테스트 신청");
				System.out.println("===========================");
				System.out.println("입력 >");
				menu = sc.nextLine();
				if(menu.equals("1")) {
					
				}else if(menu.equals("2")) {
					
				}
				break;
			case 4:
				run = false;
				MemberService.memberInfo = null;
				System.out.println("로그아웃");
				break;
			}
		}
		
	}
	
	private void Membermenu() {
		System.out.println("========================================================");
		System.out.println("1. 내 정보 조회 | 2. 내 정보 관리 | 3. 수강 및 테스트 신청 | 4. 종료");
		System.out.println("========================================================");
		System.out.println("입력 > ");
	}
}
