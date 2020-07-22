package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {
	public int insertMember(Map<String, Object> member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into member(m_num,m_name,m_id,m_pwd,m_credat)";
			sql += "values(seq_member_m_num.nextval,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pwd").toString());
			result = ps.executeUpdate();
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	@Override
	public int updateMember(Map<String, Object> member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = " update member ";
			sql += " set m_name=?,";
			sql += " m_id=?,";
			sql += " m_pwd=? ";
			sql += " where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pwd").toString());
			ps.setInt(4, (int) member.get("m_num"));
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	@Override
	public int deleteMember(int mNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from member where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		List<Map<String, Object>> memberList = new ArrayList<Map<String, Object>>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
			String sql = "select m_num,m_name,m_id,m_pwd,m_credat from member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_num", rs.getInt("m_num"));
				map.put("m_name", rs.getString("m_name"));
				map.put("m_id", rs.getString("m_id"));
				map.put("m_pwd", rs.getString("m_pwd"));
				map.put("m_credat", rs.getString("m_credat"));
				memberList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return memberList;
	}

	@Override
	public Map<String, Object> selectMember(int mNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = Connector.open();
			String sql = "select m_num,m_name,m_id,m_pwd,m_credat from member where m_num=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_num", rs.getInt("m_num"));
				map.put("m_name", rs.getString("m_name"));
				map.put("m_id", rs.getString("m_id"));
				map.put("m_pwd", rs.getString("m_pwd"));
				map.put("m_credat", rs.getString("m_credat"));
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_num", 102);
		map.put("m_id","zzzz");
		map.put("m_pwd","기모zz찌");
		map.put("m_name","기모찌zz");
		int result = mdao.updateMember(map);
		System.out.println(result);
	}
}
