package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;


import test.KeyUtils;

public class DemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		//设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		//星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序get的参数值并打印
		String account=request.getParameter("act");
		PrintWriter out=response.getWriter();
		//out.print(account);
		//out.flush();
		int appid=1400561262;
        String appkey = "33006def25303fead591f5a544fac236";
        String code = KeyUtils.keyUtils();
        String[] phoneNumbers = {account}; //手机号可以添很多。
        int templateId = 1084576;
        String smsSign = "胎儿畸形引产女性抑郁干预";
        try {
            String[] params = {code};  //第一个参数传递{1}位置想要的内容，第二个传递{2}的内容，以此类推。具体看步骤5
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            out.print(result);
            out.print(code);
           out.flush();
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
