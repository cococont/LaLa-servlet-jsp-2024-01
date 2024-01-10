package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	private final String SQL_FIND_ALL = "SELECT id,name,age FROM employees";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		try {
//			DriverManagerに org.h2.Driber を登録する
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
				("JDBCドライバの読み込みエラー");
		}
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			
			ResultSet rs = pStmt.executeQuery();
			  
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean remove(String id) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			String sql = "DELETE FROM employees WHERE id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
	}
}
