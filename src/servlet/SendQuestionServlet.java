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

public class SendQuestionServlet extends HttpServlet {
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
		String qh=request.getParameter("qh");
		String q;
		PrintWriter out=response.getWriter();
		//out.print(pact);
		//out.print(qh);
		//out.flush();
		
		if(qh.equals("BEFORE")) {
			q="first";
		}
		else {
			q="second";
		}
		//out.print(qh);
		//out.print(q);
		int affect=0;
		int affect1=0;
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			
				String sql1="select "+q+" from DP where pAccount='"+pact+ "'";
				ResultSet rs=stmt.executeQuery(sql1);
				if(rs.next()) {
					if(rs.getString(q).equals("1")) {
						out.print("�ѷ���");
						out.flush();
					}
					else {
						String sql = "update DP set "+q+"='1' where pAccount='"+pact+"'";
						if(q=="first") {
						String sql2="insert into "+q+" values('"+pact+"','','','','','','','','','','','','','','')";
						affect=stmt.executeUpdate(sql);	
						affect1=stmt.executeUpdate(sql2);
						if(affect!=0&&affect1!=0) {
							out.print("���ͳɹ�");
							out.flush();
						}
						
						else {
							affect=0;
							out.print("����ʧ��");
							out.flush();
						}
						}
						else {
							String sql2="insert into "+q+" values('"+pact+"','','','','','','','','','','','','','','','','','','','','','','','','','','')";
							affect=stmt.executeUpdate(sql);	
							affect1=stmt.executeUpdate(sql2);
							if(affect!=0&&affect1!=0) {
								out.print("���ͳɹ�");
								out.flush();
							}
							
							else {
								affect=0;
								out.print("����ʧ��");
								out.flush();
							}
						}
					}
		
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
