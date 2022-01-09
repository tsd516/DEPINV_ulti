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

public class UpdateOneServlet extends HttpServlet {
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
		String one=request.getParameter("one");
		String two=request.getParameter("two");
		String three=request.getParameter("three");
		String four=request.getParameter("four");
		String five=request.getParameter("five");
		String six=request.getParameter("six");
		String seven=request.getParameter("seven");
		String eight=request.getParameter("eight");
		String nine=request.getParameter("nine");
		String ten=request.getParameter("ten");
		String eleven=request.getParameter("eleven");
		String twelve=request.getParameter("twelve");
		PrintWriter out=response.getWriter();
	
		//out.print(pact);
		//out.print(process.length());
		//out.flush();
		int affect=0;
		while(one.indexOf(",")!=-1) {
			one=one.replace(",", "，");
		}
		while(two.indexOf(",")!=-1) {
			two=two.replace(",", "，");
		}
		while(three.indexOf(",")!=-1) {
			three=three.replace(",", "，");
		}
		
		while(four.indexOf(",")!=-1) {
			four=four.replace(",", "，");
		}
		while(five.indexOf(",")!=-1) {
			five=five.replace(",", "，");
		}
		while(six.indexOf(",")!=-1) {
			six=six.replace(",", "，");
		}
		while(seven.indexOf(",")!=-1) {
			seven=seven.replace(",", "，");
		}
		while(eight.indexOf(",")!=-1) {
			eight=eight.replace(",", "，");
		}
		while(nine.indexOf(",")!=-1) {
			nine=nine.replace(",", "，");
		}
		while(ten.indexOf(",")!=-1) {
			ten=ten.replace(",", "，");
		}
		while(eleven.indexOf(",")!=-1) {
			eleven=eleven.replace(",", "，");
		}
		while(twelve.indexOf(",")!=-1) {
			twelve=twelve.replace(",", "，");
		}
		while(one.indexOf("'")!=-1) {
			one=one.replace("'", "’");
		}
		while(two.indexOf("'")!=-1) {
			two=two.replace("'", "’");
		}
		while(three.indexOf("'")!=-1) {
			three=three.replace("'", "’");
		}
		
		while(four.indexOf("'")!=-1) {
			four=four.replace("'", "’");
		}
		while(five.indexOf("'")!=-1) {
			five=five.replace("'", "’");
		}
		while(six.indexOf("'")!=-1) {
			six=six.replace("'", "’");
		}
		while(seven.indexOf("'")!=-1) {
			seven=seven.replace("'", "’");
		}
		while(eight.indexOf("'")!=-1) {
			eight=eight.replace("'", "’");
		}
		while(nine.indexOf("'")!=-1) {
			nine=nine.replace("'", "’");
		}
		while(ten.indexOf("'")!=-1) {
			ten=ten.replace("'", "’");
		}
		while(eleven.indexOf("'")!=-1) {
			eleven=eleven.replace("'", "’");
		}
		while(twelve.indexOf("'")!=-1) {
			twelve=twelve.replace("'", "’");
		}
		
		try {
				//Connection conn=JDBCUtils.getConnection();
				Connection conn = DBHelper2.getConnection();
				Statement stmt=conn.createStatement();
				String sql1="select * from one where pact='"+pact+"'";
				
				ResultSet rs=stmt.executeQuery(sql1);
				if(rs.next()) {
				//out.print(rs.getString("one").length());
				if(rs.getString("one").length()!=0) {
					out.print("提交失败");
					out.flush();
				}
				else {
					String sql = "update one set one='"+one+"',two='"+two+"',three='"+three+"',four='"+four+"',five='"+five+"',six='"+six+"',seven='"+seven+"',eight='"+eight+"',nine='"+nine+"',ten='"+ten+"',eleven='"+eleven+"',twelve='"+twelve+"' where pact='"+pact+"'";
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
				}
				/*if(rs.next()) {
					out.print("提交失败");
					out.flush();
				
				}
				else {
					
					String sql = "update one set one='"+one+"',two='"+two+"',three='"+three+"',four='"+four+"',five='"+five+"',six='"+six+"',seven='"+seven+"',eight='"+eight+"',nine='"+nine+"',ten='"+ten+"',eleven='"+eleven+"',twelve='"+twelve+"' where pact='"+pact+"'";
					affect=stmt.executeUpdate(sql);
					
					if(affect!=0) {
						out.print("提交成功");
						out.flush();
					}
					
					else {
							out.print("提交失败");
							out.flush();
						}
				}*/
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
