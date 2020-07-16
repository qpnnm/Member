package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.LentDAO;

public class LentDAOImpl implements LentDAO {

	public int insertLent(Map<String, Object> lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into lent(l_num,l_lentdat,l_recdat,m_num,b_num)";
			sql += "values(seq_lent_l_num.nextval,sysdate,sysdate,seq_member_m_num.nextval,seq_book_b_num.nextval)";
			ps = con.prepareStatement(sql);
			ps.setString(1, lent.get("l_lentdat").toString());
			ps.setString(2, lent.get("l_recdat").toString());
			ps.setString(3, lent.get("m_num").toString());
			ps.setString(4, lent.get("b_num").toString());
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
	public int updateLent(Map<String, Object> lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = " update lent ";
			sql += " set l_lentdat=?,";
			sql += " l_recdat=?,";
			sql += " m_num=?, ";
			sql += " b_num=? ";
			sql += " where l_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, lent.get("l_lentdat").toString());
			ps.setString(2, lent.get("l_recdat").toString());
			ps.setString(3, lent.get("m_num").toString());
			ps.setString(4, lent.get("b_num").toString());
			ps.setInt(5, (int) lent.get("l_num"));
			result = ps.executeUpdate();
			con.rollback();
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
	public int deleteLent(int lNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from lent where l_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, lNum);
			result = ps.executeUpdate();
			con.rollback();
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
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		List<Map<String, Object>> lentList = new ArrayList<Map<String, Object>>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
			String sql = "select l_num,l_lentdat,l_recdat,m_num,b_num from lent";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("l_num", rs.getInt("l_num"));
				map.put("l_lentdat", rs.getString("l_lentdat"));
				map.put("l_recdat", rs.getString("l_recdat"));
				map.put("m_num", rs.getString("m_num"));
				map.put("b_num", rs.getString("b_num"));
				lentList.add(map);
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
		return lentList;
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = Connector.open();
			String sql = "select l_num,l_lentdat,l_recdat,m_num,b_num from lent where l_num=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, lNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("l_num", rs.getInt("l_num"));
				map.put("l_lentdat", rs.getString("l_lentdat"));
				map.put("l_recdat", rs.getString("l_recdat"));
				map.put("m_num", rs.getString("m_num"));
				map.put("b_num", rs.getString("b_num"));
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
		LentDAO ldao = new LentDAOImpl();
		Map<String, Object> map = new HashMap<>();

		map.put("l_num", 21);
		map.put("l_recdat", "기모찌");
		map.put("l_lentdat", "기모찌");
		map.put("m_num", "기모찌");
		map.put("b_num", 21);
		System.out.println(ldao.selectLentList(map));
	}
}
