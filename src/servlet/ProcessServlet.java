package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

public class ProcessServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ����ajax�������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//�Ǻű�ʾ���е��������󶼿��Խ���
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String account=request.getParameter("account");

		
		PrintWriter out=response.getWriter();
		//out.print(account);
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from relative where ract='"+account+ "'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				String p=rs.getString("pact");
				String sql2="select * from DP where pAccount='"+p+"'";
				ResultSet rs2=stmt.executeQuery(sql2);
				if(rs2.next()) {
					String process=rs2.getString("process");
					out.print(process);
					out.flush();
				}
				else {
					out.print("PLEASE BIND PATIENT FIRST");
				}
			}
			else {
					out.print("PLEASE BIND PATIENT FIRST");
					out.flush();
				}
			
			}
		catch(Exception e) {
				e.printStackTrace();
				out.print("δ�������ݿ�");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
