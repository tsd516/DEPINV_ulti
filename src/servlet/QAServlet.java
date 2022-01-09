package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JDBCUtils;
import tool.DBHelper2;

public class QAServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//List<String> pAccount=new ArrayList<>();
		//Map<String,Integer> items = new HashMap<>(); 
		
		List ql=new ArrayList();
		List al=new ArrayList();
		//List an=new ArrayList();
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from QA";
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			while(rs.next()) {
				//String act=rs.getString("account");
				String a=rs.getString("account").replaceAll(" ", "");
				String q=rs.getString("question");
				//String a=rs.getString("answer");
				//pAccount.add(act);
				al.add(a);
				ql.add(q);
				
				//an.add(a);
				count++;
			}
			List k=new ArrayList();
			k.add(al);
			k.add(ql);
			 out.print(k);
				out.flush();
			 //常规的循环List的方法 
			//for (int i = 0; i < count; i++) {
	          //  items.put("问题："+qu.get(i)+"编号："+pAccount.get(i)+"回答："+an.get(i),i);
	        //}
			//items.forEach((k,v)->System.out.println(" Item : "+ k + " Count : " + v));  
			

			//out.print(pAccount);
			//out.print(qu);
			//out.flush();
			//out.print(an);
			//out.flush();
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
