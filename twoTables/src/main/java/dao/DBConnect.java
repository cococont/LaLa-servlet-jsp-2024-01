package dao;

public class DBConnect {
	static final String JDBC_URL =
//			h2 database
			"jdbc:h2:tcp://localhost/~/twoTables";
//			my sql database
//			"jdbc:mysql://localhost:3306/example";
	static final String DB_USER = "sa";
	static final String DB_PASS = "";
	
	static void registerDriver() {
		try {
//			DriverManagerに org.h2.Driber を登録する
//			h2 database
			Class.forName("org.h2.Driver");
//			mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
				("JDBCドライバの読み込みエラー");
		}
	}
}
