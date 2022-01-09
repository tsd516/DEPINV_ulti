package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.DBHelper2;
import tool.JDBCUtils;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ����ajax�������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//�Ǻű�ʾ���е��������󶼿��Խ���
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String account=request.getParameter("act");
		String password=request.getParameter("pwd");
		String i=request.getParameter("i");

		
		PrintWriter out=response.getWriter();
		//out.print(i);
		try {
			Connection conn = DBHelper2.getConnection();//�������ݿ�
//			Connection conn = JDBCUtils.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from Users where account='" + account+ "' and password='" + password + "' and ident='"+i+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				String name=rs.getString("name");
				out.print(name);
				out.flush();
			}
			else {
					out.print("��¼ʧ��");
					out.flush();
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
