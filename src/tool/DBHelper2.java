package tool;

import java.sql.*;
import java.util.Scanner;

public class DBHelper2 {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://sh-cdb-lrpg765q.sql.tencentcdb.com:59785/xcx?useSSL=false&serverTimezone=Asia/Shanghai";
	
    private static final String USER = "root";
    private static final String PASS = "000515lhh";
    
    private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
			return null;
		}
		System.out.println("Á´½Ó³É¹¦");
		return con;

	}
}