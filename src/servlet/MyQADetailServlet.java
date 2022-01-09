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


public class MyQADetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ����ajax�������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//�Ǻű�ʾ���е��������󶼿��Խ���
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String qu=request.getParameter("question");
		String q;
		if(qu.substring(0, 1).equals(" ")) {
			q=qu.substring(1);
		}
		else {
			q=qu;
		}
		String account=request.getParameter("account");
		String date=request.getParameter("dt");

		PrintWriter out=response.getWriter();
		//out.print(q);
		
		List al =new ArrayList();
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			//String sql = "select * from QA where question='" + q+ "'";
			String sql="select * from QAD where question='"+q+"' and dact='"+account+"' and time='"+date+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				String asker=rs.getString("account").replaceAll(" ", "");
			//String answer=rs.getString("answer").replaceAll(" ", "");
				String answer=rs.getString("answer");
			al.add(asker);
			al.add(answer);
			out.print(al);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
