	package tool;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class JDBCUtils {
		public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost:1433;databaseName=xcx";
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//String url = "jdbc:mysql://nj-cdb-1m3y3rf3.sql.tencentcdb.com:63968/test?useSSL=false&serverTimezone=Asia/Shanghai";
		String username="sa";
		String password="123456";
		//String username="root";
		//String password="ganyu123";
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
		}		
		//关闭数据库连接，释放资源
		public static void release(Statement stmt,Connection conn) {
			if (stmt!=null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				stmt=null;
			}
			if (conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				conn=null;
			}
		}
		public static void release(ResultSet rs,Statement stmt,Connection conn) {
			if (rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				rs=null;
			}
		}

}
