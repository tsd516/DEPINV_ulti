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

public class QASubmitServlet extends HttpServlet {
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
		String question=request.getParameter("question");
		while(question.indexOf(",")!=-1) {
			question=question.replace(",", "，");
		}
		while(question.indexOf("'")!=-1) {
			question=question.replace("'", "’");
		}
		
		PrintWriter out=response.getWriter();
	
		//out.print(l);
		//out.print(process.length());
		//out.flush();
		int affect=0;
		
		try {
				//Connection conn=JDBCUtils.getConnection();
				Connection conn = DBHelper2.getConnection();
				Statement stmt=conn.createStatement();
				String sql = "insert into QA values ('"+account+"','"+question+"')";
				affect=stmt.executeUpdate(sql);
				if(affect!=0) {
					out.print("提问成功");
					out.flush();
				}
				
				else {
						out.print("提问失败");
						out.flush();
					}
				}
		catch(Exception e) {
				e.printStackTrace();
				out.print("数据库连接失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
