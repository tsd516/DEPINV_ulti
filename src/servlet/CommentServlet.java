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

public class CommentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//������Ӧͷ����ajax�������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//�Ǻű�ʾ���е��������󶼿��Խ���
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//��ȡ΢��С����get�Ĳ���ֵ����ӡ
		String pact=request.getParameter("pact");
		String a=request.getParameter("a");
		PrintWriter out=response.getWriter();
	
		while(a.indexOf(",")!=-1) {
			a=a.replace(",", "��");
		}
		while(a.indexOf("'")!=-1) {
			a=a.replace("'", "��");
		}
		int affect=0;
		
		try {
				//Connection conn=JDBCUtils.getConnection();
				Connection conn = DBHelper2.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "update one set comment='"+a+"' where pact='"+pact+"'";
				affect=stmt.executeUpdate(sql);
				if(affect!=0) {
					out.print("���۳ɹ�");
				}
				
				else {
						out.print("����ʧ��");
					}
				}
		catch(Exception e) {
				e.printStackTrace();
				out.print("���ݿ�����ʧ��");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}