package com.yedam.manager;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;

public class ManagerDAO extends DAO{
	private static ManagerDAO mngDao = null;

	private ManagerDAO(){

	}
	public static ManagerDAO getInstance() {
		if(mngDao == null) {
			mngDao = new ManagerDAO();
		}
		return mngDao;
	}
	//전체 수강생 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select m.member_id, m.member_name, c.level_id, c.start_date, c.end_date, c.test_target, c.test_result\r\n"
					+ "from member m join courseinfo c\r\n"
					+ "on m.member_id = c.member_id order by m.member_id";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setLevelId(rs.getInt("level_id"));
				member.setStartDate(rs.getDate("start_date"));
				member.setEndDate(rs.getDate("end_date"));
				member.setTestTarget(rs.getString("test_target"));
				member.setTestResult(rs.getString("test_result"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//강의별 수강생 조회
	public List<Member> getcourseList(int courseMenu){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select c.level_id, m.member_id, m.member_name, c.start_date, c.end_date, c.test_target, c.test_result\r\n"
					+ "from member m join courseinfo c\r\n"
					+ "on m.member_id = c.member_id\r\n"
					+ "where c.level_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseMenu);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setLevelId(rs.getInt("level_id"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setStartDate(rs.getDate("start_date"));
				member.setEndDate(rs.getDate("end_date"));
				member.setTestTarget(rs.getString("test_target"));
				member.setTestResult(rs.getString("test_result"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	//회원 삭제
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
