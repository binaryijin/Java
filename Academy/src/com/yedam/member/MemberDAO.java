package com.yedam.member;


import java.sql.Date;
import java.util.Calendar;

import com.yedam.common.DAO;

public class MemberDAO extends DAO {
	private static MemberDAO memDao = null;
	
	private MemberDAO(){
		
	}
	public static MemberDAO getInstance() {
		if(memDao == null) {
			memDao = new MemberDAO();
		}
		return memDao;
	}
	
	//로그인
	
	public Member login (String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberAuth(rs.getString("member_auth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	//회원 가입
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO member VALUES(?, ?, ?, 'S')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//내 정보 조회 - 수강 정보 조회
	public Member getCourseInfo (String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from courseinfo where member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setLevelId(rs.getInt("level_id"));
				member.setStartDate(rs.getDate("start_date"));
				member.setDuration(rs.getInt("duration"));
				member.setTestTarget(rs.getString("test_target"));
				member.setTestResult(rs.getString("test_result"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	//비밀번호 수정
	public int updatePw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_pw = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	

	//수강신청
	public int insertCourse( int selectLevel, int selectDuration) {
		int result = 0;
		try {
			conn();
//			String sql = "INSERT INTO courseinfo (member_id, level_id, start_date, end_date) VALUES (?, ?, SYSDATE, ?)";
			String sql = "INSERT INTO courseinfo VALUES (?, ?, sysdate, ?, null, null)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
            pstmt.setInt(2, selectLevel);
            pstmt.setInt(3, selectDuration);
            
            result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	

	

	
	
	
	
	
	
	
//	public int insertCourse(Member member, int selectLevel, int selectDuration) {
//		int result = 0;
//		try {
//			conn();
////			String sql = "INSERT INTO courseinfo (member_id, level_id, start_date, end_date) VALUES (?, ?, SYSDATE, ?)";
//			String sql = "INSERT INTO courseinfo VALUES (?, ?, ?, sysdate, ?, null, null)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, MemberService.memberInfo.getMemberId());
//            pstmt.setInt(2, selectLevel);
//            pstmt.setString(3, me);
//            
//            Calendar endDate = Calendar.getInstance();
//            endDate.add(Calendar.MONTH, selectDuration);
//            
//            
//            pstmt.setDate(4, new Date(endDate.getInstance().getTimeInMillis()));
//            
//            result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return result;
//	}
	
	//내 정보 조회
//	public List<Member> getMemberInfo(){
//		List<Member> list = new ArrayList<>();
//		Member member = null;
//		try {
//			conn();
//			String sql = "select m.member_id, m.member_pw, m.member_name ,m.member_phone, c.course_start, c.course_end\r\n"
//					+ "from member m join course c\r\n"
//					+ "on m.member_id = c.member_id\r\n"
//					+ "where m.member_id =? ";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, MemberService.memberInfo.getMemberId());
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				member = new Member();
//				member.setMemberId(rs.getString("member_id"));
//				member.setMemberPw(rs.getString("member_pw"));
//				member.setMemberName(rs.getString("member_name"));
//				member.setMemberPhone(rs.getString("member_phone"));
//				member.setCourseStart(rs.getDate("course_start"));
//				member.setCourseEnd(rs.getDate("course_end"));
//				
//				list.add(member);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return list;
//	}
	
	
	
}