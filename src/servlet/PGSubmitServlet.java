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

public class PGSubmitServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String account=request.getParameter("account");
		String title=request.getParameter("title");
		String context=request.getParameter("context");
		String link=request.getParameter("link");
		String name=request.getParameter("name");
		
		while(context.indexOf(",")!=-1) {
			context=context.replace(",", "，");
		}
		
		while(title.indexOf(",")!=-1) {
			title=title.replace(",", "，");
		}
		while(context.indexOf("'")!=-1) {
			context=context.replace("'", "’");
		}
		
		while(title.indexOf("'")!=-1) {
			title=title.replace("'", "’");
		}
		PrintWriter out=response.getWriter();
	
		//out.print(l);
		//out.print(process.length());
		//out.flush();
		//out.print(context);
		int affect=0;
		
		try {
				//Connection conn=JDBCUtils.getConnection();
				Connection conn = DBHelper2.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "insert into PG values ('"+account+"','"+name+"','"+title+"','"+context+"',0,'"+link+"')";
				affect=stmt.executeUpdate(sql);
				if(affect!=0) {
					out.print("发布成功");
					out.flush();
				}
				
				else {
						out.print("发布失败");
						out.flush();
					}
				}
		catch(Exception e) {
				e.printStackTrace();
				out.print("数据库连接失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
