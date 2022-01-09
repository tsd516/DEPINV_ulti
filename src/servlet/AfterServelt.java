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


public class AfterServelt extends HttpServlet {
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
		List oo=new ArrayList();
		List pp=new ArrayList();
		List qq=new ArrayList();
		List rr=new ArrayList();
		List ss=new ArrayList();
		List tt=new ArrayList();
		List uu=new ArrayList();
		List vv=new ArrayList();
		List ww=new ArrayList();
		List xx=new ArrayList();
		List yy=new ArrayList();
		List zz=new ArrayList();
		List z=new ArrayList();
		PrintWriter out=response.getWriter();
		//out.print(dact);
		//out.print(pact);
		int affect=0;
		try {
		//Connection conn=JDBCUtils.getConnection();
		Connection conn = DBHelper2.getConnection();
		Statement stmt=conn.createStatement();
		String sql = "select * from `after` where pact='"+pact+ "' and unit='"+unit+"'";
		
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
			String tone=rs.getString("tone");
			String ttwo=rs.getString("ttwo");
			String tthree=rs.getString("tthree");
			String tfour=rs.getString("tfour");
			String tfive=rs.getString("tfive");
			String tsix=rs.getString("tsix");
			String tseven=rs.getString("tseven");
			String sone=rs.getString("sone");
			String stwo=rs.getString("stwo");
			String sthree=rs.getString("sthree");
			String sfour=rs.getString("sfour");
			String sfive=rs.getString("sfive");
			String ssix=rs.getString("ssix");
			String sseven=rs.getString("sseven");
			String seight=rs.getString("seight");
			String snine=rs.getString("snine");
			
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
				kk.add(tone);
				ll.add(ttwo);
				mm.add(tthree);
				nn.add(tfour);
				oo.add(tfive);
				pp.add(tsix);
				qq.add(tseven);
				rr.add(sone);
				ss.add(stwo);
				tt.add(sthree);
				uu.add(sfour);
				vv.add(sfive);
				ww.add(ssix);
				xx.add(sseven);
				yy.add(seight);
				zz.add(snine);
				
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
				z.add(oo);
				z.add(pp);
				z.add(qq);
				z.add(rr);
				z.add(ss);
				z.add(tt);
				z.add(uu);
				z.add(vv);
				z.add(ww);
				z.add(xx);
				z.add(yy);
				z.add(zz);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
