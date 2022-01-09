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


public class ACTServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String account=request.getParameter("account");

		
		PrintWriter out=response.getWriter();
		//out.print(account);
		int affect=0;
		try {
			//Connection conn=JDBCUtils.getConnection();//连接数据库
			Connection conn = DBHelper2.getConnection();
			Statement stmt=conn.createStatement();
			String sql = "select * from relative where ract='"+account+ "'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				String p=rs.getString("pact");
				//out.print(p);
				String sql2="select * from DP where pAccount='"+p+"'";
				ResultSet rs2=stmt.executeQuery(sql2);
				if(rs2.next()) {
					String one=rs2.getString("one").replaceAll(" ", "");
					String two=rs2.getString("two").replaceAll(" ", "");
					String three=rs2.getString("three").replaceAll(" ", "");
					String four=rs2.getString("four").replaceAll(" ", "");
					String five=rs2.getString("five").replaceAll(" ", "");
					String six=rs2.getString("six").replaceAll(" ", "");
					//out.print(one);
					//out.print(six);
					//out.print(six.equals("1"));
					if(six.equals("1")) {
						out.print("UNIT6 : COMMITMENT TO ACTION");
					}
					else if(five.equals("1")) {
						out.print("UNIT5 : LIVE IN THE MOMENT");
					}
					else if(four.equals("1")) {
						out.print("UNIT4 : LOOK AT YOURSELF");
					}
					else if(three.equals("1")) {
						out.print("UNIT3 : LEARN TO ACCEPT");
					}
					else if(two.equals("1")) {
						out.print("UNIT2 : COGNITIVE DISSOCIATION");
					}
					else if(one.equals("1")) {
						out.print("UNIT1 : INTRODUCTION TO ACT");
					}
					else {
						out.print("HAVE NOT BEGUN");
					}
				}
				else {
					out.print("PLEASE BIND PATIENT FIRST");
				}
			}
			else {
					out.print("PLEASE BIND PATIENT FIRST");
					out.flush();
				}
			
			}
		catch(Exception e) {
				e.printStackTrace();
				out.print("未连接数据库");
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
