package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.dept.Dept;

public class EmployeesDAO {
	private final String SQL_FIND_ALL =
			"SELECT"
			+ "  e.id AS id, "
			+ "  e.name AS name, "
			+ "  e.age AS age, "
			+ "  d.id AS did, "
			+ "  d.name AS dname "
			+ "FROM employees e "
			+ "  LEFT OUTER JOIN dept d "
			+ "  ON e.dept_id = d.id "
			+ "ORDER BY e.id;";

	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			
			ResultSet rs = pStmt.executeQuery();
			  
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				
				Employee employee = new Employee(id, name, age, dept);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean create(Employee emp) {
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)){
			String sql = "INSERT INTO employees (id, name, age, dept_id) VALUES (?,?,?,?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			pStmt.setString(4, emp.getDept().getId());
			
			int result = pStmt.executeUpdate();
			return (result == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	未改修
	public boolean remove(String id) {
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)){
			String sql = "DELETE FROM employees WHERE id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	すでに存在するIDなら true
	public boolean isExistsId(String id) {
		DBConnect.registerDriver();
		
		try (Connection conn = DriverManager.getConnection(
				DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)){
			String sql = "SELECT id FROM employees WHERE id = ?;";
//			String sql = "SELECT COUNT(*) id FROM employees WHERE id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}
}
