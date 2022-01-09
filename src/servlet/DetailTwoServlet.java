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

public class DetailTwoServlet extends HttpServlet {
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
			
		PrintWriter out=response.getWriter();
		try {
			//Connection conn=JDBCUtils.getConnection();//�������ݿ�
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from two where pact='"+pact+"'";
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()) {
				String a=rs.getString("one").replaceAll(" ","");
				String b=rs.getString("two").replaceAll(" ","");
				String c=rs.getString("three").replaceAll(" ","");
				String d=rs.getString("four").replaceAll(" ","");
				String e=rs.getString("five").replaceAll(" ","");
				String f=rs.getString("six").replaceAll(" ","");
				String g=rs.getString("seven").replaceAll(" ","");
				String h=rs.getString("eight").replaceAll(" ","");
				String i=rs.getString("nine").replaceAll(" ","");
				String j=rs.getString("ten").replaceAll(" ","");
				String m=rs.getString("comment").replaceAll(" ", "");
				out.print("a:"+a+"b:"+b+"c:"+c+"d:"+d+"e:"+e+"f:"+f+"g:"+g+"h:"+h+"i:"+i+"j:"+j+"m:"+m);
				out.flush();
				
			}
			 
			
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
