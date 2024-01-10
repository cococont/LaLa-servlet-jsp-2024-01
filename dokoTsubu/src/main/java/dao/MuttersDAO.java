package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MuttersDAO {
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/dokoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException (
				"JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id,name,text FROM mutters ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try (Connection comm = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO mutters(name,text) VALUES(?,?)";
			PreparedStatement pStmt = comm.prepareStatement(sql);
			
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
