package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.DBHelper2;
import tool.JDBCUtils;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String account=request.getParameter("act");
		String password=request.getParameter("pwd");
		String i=request.getParameter("i");

		
		PrintWriter out=response.getWriter();
		//out.print(i);
		try {
			Connection conn = DBHelper2.getConnection();//连接数据库
//			Connection conn = JDBCUtils.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from Users where account='" + account+ "' and password='" + password + "' and ident='"+i+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				String name=rs.getString("name");
				out.print(name);
				out.flush();
			}
			else {
					out.print("登录失败");
					out.flush();
				}
		}
		catch(Exception e) {
				e.printStackTrace();
				out.print("数据库连接失败");
				out.flush();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
