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
public class SendLinkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String pact=request.getParameter("pact");
		
		PrintWriter out=response.getWriter();
		//out.print(pact);
		//out.print(process);
		//out.flush();
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "update DP set link='wx34396069ed64c2b3;mp://AGC2DH6V5jAaZ3w;http://pit.cssfybjy.com/WX/Schedule/QuickRegist?code=033YtLFa1d4bLA0dKxIa1ejze54YtLFV&state=wx0258582539e0f49c&accountID=688963&sheetid=01787990-4000-ae4e-6d21-ea26b8bd536c&status=0' where pAccount='"+pact+"'";
			affect=stmt.executeUpdate(sql);	
			if(affect!=0) {
				out.print("发送成功");
				out.flush();
			}
			
			else {
				affect=0;
				out.print("发送失败");
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
