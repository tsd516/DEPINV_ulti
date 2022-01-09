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

import tool.DBHelper2;


public class AfterStartServelt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String pact=request.getParameter("act");
		String unit=request.getParameter("unit");
		String q;
		PrintWriter out=response.getWriter();
		//out.print(pact);
		//out.print(qh);
		//out.flush();
		//out.print(qh);
		//out.print(q);
		int affect=0;
		
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql="insert into `after` values('"+pact+"','"+unit+"','','','','','','','','','','','','','','','','','','','','','','','','','','')";
				
				affect=stmt.executeUpdate(sql);
				if(affect!=0) {
					out.print("发送成功");
					out.flush();
				}
				else {
					out.print("发送失败");
					out.flush();
							}
							
							
			}
			
		catch(Exception e) {
				e.printStackTrace();
				out.print("数据库连接失败");
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
