package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dept.Dept;

public class DeptDAO {
	private final String SQL_FIND_ALL =
			"SELECT * FROM dept;";
	private final String SQL_FIND_NAME_BY_ID =
			"SELECT name FROM dept WHERE id = ?;";
	private final String SQL_IS_EXISTS_DEPT_ID =
			"SELECT name FROM dept WHERE id = ?;";

	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			
			ResultSet rs = pStmt.executeQuery();
			  
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}
	
	public String findNameById(String id) {
		String name = null;
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_NAME_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			  
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
//	すでに存在するIDなら true
	public boolean isExistsId(String id) {
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)){
			String sql = SQL_IS_EXISTS_DEPT_ID;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
