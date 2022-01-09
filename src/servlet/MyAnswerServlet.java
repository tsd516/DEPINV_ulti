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
public class MyAnswerServlet extends HttpServlet {
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

		List qAccount=new ArrayList();
		List dl=new ArrayList();
		PrintWriter out=response.getWriter();
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from QAD where dact='" + account+"' ORDER BY time DESC";
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			while(rs.next()) {
					//String q=rs.getString("question").replaceAll(" ","");
				String q=rs.getString("question");
					String d=rs.getString("time");
					qAccount.add(q);
					dl.add(d);
					count++;
			}
			List k=new ArrayList();
			k.add(qAccount);
			k.add(dl);
			out.print(k);
			out.flush();
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
