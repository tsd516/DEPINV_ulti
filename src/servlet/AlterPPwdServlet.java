package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

public class AlterPPwdServlet extends HttpServlet {
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
		String again=request.getParameter("apwd");

		
		PrintWriter out=response.getWriter();
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "update DP set password='"+password+"' where pAccount='"+account+"'";
			if(password.equals(again)) {
				affect=stmt.executeUpdate(sql);
				out.print("�޸ĳɹ�");
				out.flush();
			}
			else {
					affect=0;
					out.print("�޸�ʧ��");
					out.flush();
				}
			}
		catch(Exception e) {
				e.printStackTrace();
				out.print("���ݿ�����ʧ��");
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
