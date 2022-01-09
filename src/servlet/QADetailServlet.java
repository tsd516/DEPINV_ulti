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

public class QADetailServlet extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		if(q.indexOf(" ")==0) {
			q=q.replaceFirst(" ", "");
		}
		else {
			q=q;
		}
		
		//out.print(q);
		//String ac="";
		//List acc=new ArrayList();
		List dl=new ArrayList();
		List al=new ArrayList();
		List nl=new ArrayList();
		List tl=new ArrayList();
		List il=new ArrayList();
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			//String sql = "select * from QA where question='" + q+ "'";
			String sql="select * from QAD where question='"+q+"' ORDER BY time DESC";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
			//String account=rs.getString("account").replaceAll(" ","");
			String answer=rs.getString("answer");
			String dact=rs.getString("dact").replaceAll(" ","");
			String name=rs.getString("name").replaceAll(" ", "");
			String ident=rs.getString("ident").replace(" ","");
			String date=rs.getString("time");
			
			//ac=account;
			al.add(answer);
			dl.add(dact);
			nl.add(name);
			tl.add(date);
			il.add(ident);
			//out.println("n："+q+"k："+account+"r："+answer+"t："+dact);
			//out.flush();
			}
			List k=new ArrayList();
			//k.add(ac);
			k.add(dl);
			k.add(al);
			k.add(nl);
			k.add(tl);
			k.add(il);
			out.print(k);
			//out.print(ac);
			//out.print(al);
			//out.print(dl);
			
			//out.print("n:"+q+"k:"+ac+"r:"+dl);
			out.flush();
			
			//else {
				//out.print("有误");
			//}
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
