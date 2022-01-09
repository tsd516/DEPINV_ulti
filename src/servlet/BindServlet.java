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
public class BindServlet extends HttpServlet {
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
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		
		PrintWriter out=response.getWriter();
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from DP where pAccount='" + id+ "' and name='" + name + "'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				String sql2="insert into relative values('"+id+"','"+account+"')";
				affect=stmt.executeUpdate(sql2);
				if(affect!=0) {
					out.print("绑定成功");
					out.flush();
				}
				else {
					out.print("绑定失败");
					out.flush();
				}
			}
			else {
					out.print("绑定失败");
					out.flush();
				}
			
			}
		catch(Exception e) {
				e.printStackTrace();
				out.print("未连接数据库");
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
