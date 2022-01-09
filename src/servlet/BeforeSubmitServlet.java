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

import tool.DBHelper2;

public class BeforeSubmitServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String unit=request.getParameter("unit");
		String pact=request.getParameter("a");
		String age=request.getParameter("age");
		String two=request.getParameter("two");
		String three=request.getParameter("three");
		String four=request.getParameter("four");
		String five=request.getParameter("five");
		String six=request.getParameter("six");
		String seven=request.getParameter("seven");
		String eight=request.getParameter("eight");
		String nine=request.getParameter("nine");
		String day=request.getParameter("day");
		String eleven=request.getParameter("eleven");
		String twelve=request.getParameter("twelve");
		String thirteen=request.getParameter("thirteen");
		String fourteen=request.getParameter("fourteen");
		PrintWriter out=response.getWriter();
		while(age.indexOf(",")!=-1) {
			age=age.replace(",", "，");
		}
		while(day.indexOf("'")!=-1) {
			day=day.replace(",", "，");
		}
		int affect=0;
		//out.print(pact);
		//out.print(age);
		//out.print(two);
		//out.print(three);
		//out.print(four);
		//out.print(five);
		//out.print(eleven);
		//out.print(twelve);
		//out.print(thirteen);
		//out.print(fourteen);
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			
			String sql = "update `before` set one='"+age+"',two='"+two+"',three='"+three+"',four='"+four+"',five='"+five+"',six='"+six+"',seven='"+seven+"',eight='"+eight+"',nine='"+nine+"',ten='"+day+"',eleven='"+eleven+"',twelve='"+twelve+"',thirteen='"+thirteen+"',fourteen='"+fourteen+"' where pact='"+pact+"' and unit='"+unit+"'";
			
			affect=stmt.executeUpdate(sql);
			
				
				if(affect!=0) {
					out.print("提交成功");
					out.flush();
				}
				
				else {
						out.print("提交失败");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
