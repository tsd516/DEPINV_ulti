package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tool.DBHelper2;

public class Test2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psm = null;
		try {
			con = DBHelper2.getConnection();
			String sql = "select account from Users";
			psm = con.prepareStatement(sql);

			ResultSet result = psm.executeQuery();
			while (result.next()) {
		        String id = result.getString("account");
		        System.out.println(id);
		    }
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

