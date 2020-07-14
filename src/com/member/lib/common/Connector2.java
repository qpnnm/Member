package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector2 {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection open() {
		try {
			return DriverManager.getConnection(URL, ID, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = open();
			String sql = "select * from lent";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("l_lentdat"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();

				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
