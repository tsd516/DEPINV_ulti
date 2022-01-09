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
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String q=request.getParameter("question");
		String d=request.getParameter("dact").replaceAll(" ", "");
		PrintWriter out=response.getWriter();
		
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
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
				out.print("有误");
			}
		}
		catch(Exception e) {
				e.printStackTrace();
				out.print("数据库连接失败");
				out.flush();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
