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

import tool.JDBCUtils;
import tool.DBHelper2;

public class PGDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String t=request.getParameter("title");
		PrintWriter out=response.getWriter();
		//out.print(q);
		List al=new ArrayList();
		List c=new ArrayList();
		List ac=new ArrayList();
		List za=new ArrayList();
		List li=new ArrayList();
		List na=new ArrayList();
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from PG where title='" + t+ "'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
			String account=rs.getString("account").replaceAll(" ","");
			//String context=rs.getString("context").replaceAll(" ", "");
			String context=rs.getString("context");
			String zan=rs.getString("zan").replaceAll(" ", "");
			String link=rs.getString("link").replaceAll(" ", "");
			String name=rs.getString("name").replaceAll(" ", "");
			//ql.add(q);
			//ql.add(account);
			//ql.add(answer);
			c.add(context);
			ac.add(account);
			za.add(zan);
			li.add(link);
			na.add(name);
			al.add(ac);
			al.add(c);
			al.add(za);
			al.add(li);
			al.add(na);
			out.print(al);
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
		doGet(request, response);
	}

}
