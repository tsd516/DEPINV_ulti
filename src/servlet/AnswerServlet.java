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

public class AnswerServlet extends HttpServlet {
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
		String answer=request.getParameter("a");
		//String answer=an.replaceAll(",", ";");
		String q=request.getParameter("question");
		String pact=request.getParameter("pact");
		String date=request.getParameter("d");
		String name=request.getParameter("dname");
		String ident=request.getParameter("ident");
		PrintWriter out=response.getWriter();
		if(q.indexOf(" ")==0) {
			q=q.replaceFirst(" ", "");
		}
		/*while(answer.indexOf("?")!=-1) {
			answer=answer.replace("?", "��");
		}*/
		while(answer.indexOf(",")!=-1) {
			answer=answer.replace(",", "��");
		}
		while(answer.indexOf("'")!=-1) {
			answer=answer.replace("'", "��");
		}
//out.print(account);
//out.print(answer);
//out.print(q);
//out.print(pact);
//out.print(date);
//out.print(name);
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			//String sql = "update QA set dact='"+account+"',answer='"+answer+"' where question='"+q+"'";
			String sql="insert into QAD values ('"+pact+"','"+q+"','"+account+"','"+name+"','"+answer+"','"+date+"','"+ident+"')";
			affect=stmt.executeUpdate(sql);
			if(affect!=0) {
				out.print("�ύ�ɹ�");
			}
			
			else {
					out.print("�ύʧ��");
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
