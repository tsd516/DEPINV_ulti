package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;
public class MyPatientServlet extends HttpServlet {
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

	List pAccount=new ArrayList();
	PrintWriter out=response.getWriter();

	try {
		//Connection conn=JDBCUtils.getConnection();//�������ݿ�
		Connection conn = DBHelper2.getConnection();
		Statement stmt=conn.createStatement();
		String sql = "select * from DP where dAccount='" + account+"'";
		ResultSet rs=stmt.executeQuery(sql);
		int count=0;
		while(rs.next()) {
				String pa=rs.getString("pAccount");
				pAccount.add(pa);
				count++;
		}
		
		out.print(pAccount);
		out.flush();
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
