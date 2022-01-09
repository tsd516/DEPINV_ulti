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

public class DetailOneServlet extends HttpServlet {
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
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from one where pact='"+pact+"'";
			ResultSet rs=stmt.executeQuery(sql);
			List aa=new ArrayList();
			List bb=new ArrayList();
			List cc=new ArrayList();
			List dd=new ArrayList();
			List ee=new ArrayList();
			List ff=new ArrayList();
			List gg=new ArrayList();
			List hh=new ArrayList();
			List ii=new ArrayList();
			List jj=new ArrayList();
			List kk=new ArrayList();
			List ll=new ArrayList();
			List mm=new ArrayList();
			List z=new ArrayList();
			int count=0;
			if(rs.next()) {
				String a=rs.getString("one");
				String b=rs.getString("two");
				String c=rs.getString("three");
				String d=rs.getString("four");
				String e=rs.getString("five");
				String f=rs.getString("six");
				String g=rs.getString("seven");
				String h=rs.getString("eight");
				String i=rs.getString("nine");
				String j=rs.getString("ten");
				String k=rs.getString("eleven");
				String l=rs.getString("twelve");
				String m=rs.getString("comment");
				
				aa.add(a);
				bb.add(b);
				cc.add(c);
				dd.add(d);
				ee.add(e);
				ff.add(f);
				gg.add(g);
				hh.add(g);
				ii.add(i);
				jj.add(i);
				kk.add(k);
				ll.add(l);
				mm.add(m);
				z.add(aa);
				z.add(bb);
				z.add(cc);
				z.add(dd);
				z.add(ee);
				z.add(ff);
				z.add(gg);
				z.add(hh);
				z.add(ii);
				z.add(jj);
				z.add(kk);
				z.add(ll);
				z.add(mm);
				out.print(z);
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
