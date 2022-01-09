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


public class AfterSubmitServlet extends HttpServlet {
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
		String tone=request.getParameter("tone");
		String ttwo=request.getParameter("ttwo");
		String tthree=request.getParameter("tthree");
		String tfour=request.getParameter("tfour");
		String tfive=request.getParameter("tfive");
		String tsix=request.getParameter("tsix");
		String tseven=request.getParameter("tseven");
		String sone=request.getParameter("sone");
		String stwo=request.getParameter("stwo");
		String sthree=request.getParameter("sthree");
		String sfour=request.getParameter("sfour");
		String sfive=request.getParameter("sfive");
		String ssix=request.getParameter("ssix");
		String sseven=request.getParameter("sseven");
		String seight=request.getParameter("seight");
		String snine=request.getParameter("snine");
		PrintWriter out=response.getWriter();
		int affect=0;
		/*out.print(pact);
		out.print(one);
		out.print(two);
		out.print(three);
		out.print(four);
		out.print(five);
		out.print(six);
		out.print(seven);
		out.print(eight);
		out.print(nine);
		out.print(ten);
		out.print(tone);
		out.print(ttwo);
		out.print(tthree);
		out.print(tfour);
		out.print(tfive);
		out.print(tsix);
		out.print(tseven);
		out.print(sone);
		out.print(stwo);
		out.print(sthree);
		out.print(sfour);
		out.print(sfive);
		out.print(ssix);
		out.print(sseven);
		out.print(seight);
		out.print(snine);
		*/
		try {
			//Connection conn=JDBCUtils.getConnection();
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			
			String sql = "update `after` set one='"+one+"',two='"+two+"',three='"+three+"',four='"+four+"',five='"+five+"',six='"+six+"',seven='"+seven+"',eight='"+eight+"',nine='"+nine+"',ten='"+ten+"',tone='"+tone+"',ttwo='"+ttwo+"',tthree='"+tthree+"',tfour='"+tfour+"',tfive='"+tfive+"',tsix='"+tsix+"',tseven='"+tseven+"',sone='"+sone+"',stwo='"+stwo+"',sthree='"+sthree+"',sfour='"+sfour+"',sfive='"+sfive+"',ssix='"+ssix+"',sseven='"+sseven+"',seight='"+seight+"',snine='"+snine+"' where pact='"+pact+"' and unit='"+unit+"'";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
