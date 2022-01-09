package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

public class AlterProcess extends HttpServlet {
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
		String index=""+request.getParameter("index");
		PrintWriter out=response.getWriter();
	
		//out.print(l);
		//out.print(process.length());
		//out.flush();
		int affect=0;
		String process;
		if(index.equals("0")) {
				process="DENIAL";
			}
			else if(index.equals("1")) {
				process="VERIFICATION";
			}
			else if(index.equals("2")) {
				process="DECISION";
			}
			else {
				process="RECOVERY";
			}
		
		try {
				//Connection conn=JDBCUtils.getConnection();
				Connection conn = DBHelper2.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "update DP set process='"+process+"' where pAccount='"+pact+"'";
				affect=stmt.executeUpdate(sql);
				if(affect!=0) {
					out.print("�޸ĳɹ�");
				}
				
				else {
						out.print("�޸�ʧ��");
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
