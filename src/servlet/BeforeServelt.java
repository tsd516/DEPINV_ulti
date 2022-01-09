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

import tool.DBHelper2;


public class BeforeServelt extends HttpServlet {
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
		List nn=new ArrayList();
		List z=new ArrayList();
		PrintWriter out=response.getWriter();
		//out.print(unit);
		//out.print(pact);
		int affect=0;
		try {
		//Connection conn=JDBCUtils.getConnection();
		Connection conn = DBHelper2.getConnection();
		Statement stmt=conn.createStatement();
		String sql = "select * from `before` where pact='"+pact+"' and unit='"+unit+"'";
		
		ResultSet rs=stmt.executeQuery(sql);
		
		if(rs.next()) {
			String one=rs.getString("one");
			String two=rs.getString("two");
			String three=rs.getString("three");
			String four=rs.getString("four");
			String five=rs.getString("five");
			String six=rs.getString("six");
			String seven=rs.getString("seven");
			String eight=rs.getString("eight");
			String nine=rs.getString("nine");
			String ten=rs.getString("ten");
			String eleven=rs.getString("eleven");
			String twelve=rs.getString("twelve");
			String thirteen=rs.getString("thirteen");
			String fourteen=rs.getString("fourteen");
			if(one.length()!=0) {
				//out.print("已填写");
				//out.print(one);
				aa.add(one);
				bb.add(two);
				cc.add(three);
				dd.add(four);
				ee.add(five);
				ff.add(six);
				gg.add(seven);
				hh.add(eight);
				ii.add(nine);
				jj.add(ten);
				kk.add(eleven);
				ll.add(twelve);
				mm.add(thirteen);
				nn.add(fourteen);
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
				z.add(nn);
				out.print(z);
				out.flush();
			}
			else {
			out.print("已发送");
			//out.print(one);
			//out.print(one.length());
			out.flush();
			}
		}
		else {
			out.print("未发送");
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
