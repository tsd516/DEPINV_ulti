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

import tool.DBHelper2;


public class AnswerDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ����ajax�������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//�Ǻű�ʾ���е��������󶼿��Խ���
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String q=request.getParameter("question");
		String d=request.getParameter("dact").replaceAll(" ", "");
		PrintWriter out=response.getWriter();
		
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			//String sql = "select * from QA where question='" + q+ "'";
			String sql="select * from QAD where question='"+q+"' and dact='"+d+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
			String answer=rs.getString("answer").replaceAll(" ", "");
			out.print(answer);
			out.flush();
			}
		else {
				out.print("����");
			}
		}
		catch(Exception e) {
				e.printStackTrace();
				out.print("���ݿ�����ʧ��");
				out.flush();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
