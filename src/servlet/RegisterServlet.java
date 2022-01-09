package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		String identity=request.getParameter("identity");
		String name=request.getParameter("name");
		
		PrintWriter out=response.getWriter();
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql="insert into Users values('"+account+"','"+password+"','"+identity+"','"+name+"')"; 
			affect=stmt.executeUpdate(sql);
			
			}
		catch(Exception e) {
				e.printStackTrace();
				out.print("δ�������ݿ�");
				}
		if(affect!=0) {
				out.print("ע��ɹ�");
				out.flush();
			}else {
				out.print("ע��ʧ��");
				out.flush();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
