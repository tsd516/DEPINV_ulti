package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

public class PGServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();

		List qu=new ArrayList();
		
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from PG";
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			while(rs.next()) {
				String t=rs.getString("title");
				out.print(t+",");
				out.flush();
				count++;
			}
			 
			
		}
		catch(Exception e) {
				e.printStackTrace();
				out.print("���ݿ�����ʧ��");
				out.flush();
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
