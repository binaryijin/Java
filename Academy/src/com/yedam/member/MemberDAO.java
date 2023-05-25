package com.yedam.member;

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
	
	//회원 가입 - 기본 정보
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
				member.setEndDate(rs.getString("end_date"));
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
	

	//수강 신청 유무 확인
	public Member checkCourse(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from courseinfo where member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setLevelId(rs.getInt("level_id"));
				member.setStartDate(rs.getDate("start_date"));
				member.setDuration(rs.getInt("duration"));
				member.setEndDate(rs.getString("end_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	//수강신청 미완성!@!!!@!
	public int insertCourse( int selectLevel, int selectDuration) {
		int result = 0;
		try {
			conn();
//			String sql = "INSERT INTO courseinfo VALUES (?, ?, sysdate, ?, null , null, null)"; //end_date 수정
			String sql = "insert into courseinfo values(?, ?, sysdate, ?, to_char(add_months(sysdate, ?)), null, null)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
            pstmt.setInt(2, selectLevel);
            pstmt.setInt(3, selectDuration);
            pstmt.setInt(4, selectDuration);
            
            result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
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
