
package test;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsStatusPuller;
import com.github.qcloudsms.SmsMobileStatusPuller;
import com.github.qcloudsms.SmsStatusPullCallbackResult;
import com.github.qcloudsms.SmsStatusPullReplyResult;
import com.github.qcloudsms.SmsVoiceVerifyCodeSender;
import com.github.qcloudsms.SmsVoiceVerifyCodeSenderResult;
import com.github.qcloudsms.SmsVoicePromptSender;
import com.github.qcloudsms.SmsVoicePromptSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import java.io.IOException;
public class QcloudSmsTest {
    public static void main(String[] args) {
        int appid=1400561262;
        String appkey = "33006def25303fead591f5a544fac236";
        String[] phoneNumbers = {"15067501763"}; //手机号可以添很多。
        int templateId = 1084576;
        String smsSign = "胎儿畸形引产女性抑郁干预";
        try {
            String[] params = {"1231"};  //第一个参数传递{1}位置想要的内容，第二个传递{2}的内容，以此类推。具体看步骤5
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
public class QcloudSmsTest {
    public static String sendSMS(HttpServletRequest request, String phoneNumber) {
        String reStr = ""; //定义返回值
        // 短信应用SDK AppID  1400开头
        int appid = 1400009099 ;
        // 短信应用SDK AppKey
        String appkey = "2b49cd1b64b8d0de9f51c67c43b193cd";
        // 短信模板ID，需要在短信应用中申请
        int templateId = 1084576 ;
        // 签名，使用的是签名内容，而不是签名ID
        String smsSign = "胎儿畸形引产女性抑郁干预";
        //随机生成四位验证码的工具类
        String code = keyUtil.keyUtils();
        try {
            //参数，一定要对应短信模板中的参数顺序和个数，
            String[] params = {code};
            //创建ssender对象
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //发送
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,templateId, params, smsSign, "", "");
            if(result.result!=0){
                reStr = "error";
            }
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            HttpSession session = request.getSession();
            //JSONObject存入数据
            JSONObject json = new JSONObject();
            json.put("Code", code);//存入验证码
            json.put("createTime", System.currentTimeMillis());//存入发送短信验证码的时间
            // 将验证码和短信发送时间码存入SESSION
            request.getSession().setAttribute("MsCode", json);
            reStr = "success";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }catch (Exception e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return reStr;
    }
 
}
public class QcloudSmsTest {

    public static void main(String[] args) {
       
        int appid = 1400009099; 

       
        String appkey = "2b49cd1b64b8d0de9f51c67c43b193cd";

        
        String[] phoneNumbers = {"15067501763"};

      
        int templateId = 1084576;

       
        String smsSign = "胎儿畸形引产女性抑郁干预";

      
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                "【腾讯云】您的验证码是: 1231", "", "");
            System.out.print(result);
        } catch (HTTPException e) {
            
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

       
        try {
            String[] params = {"1231"};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers,
                templateId, params, smsSign, "", "");  
            System.out.print(result);
        } catch (HTTPException e) {
            
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

       
        try {
            SmsVoiceVerifyCodeSender vvcsender = new SmsVoiceVerifyCodeSender(appid,appkey);
            SmsVoiceVerifyCodeSenderResult result = vvcsender.send("86", phoneNumbers[0],
                "5678", 2, "");
            System.out.print(result);
        } catch (HTTPException e) {
            
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
          
            e.printStackTrace();
        }

      
        try {
            SmsVoicePromptSender vpsender = new SmsVoicePromptSender(appid, appkey);
            SmsVoicePromptSenderResult result = vpsender.send("86", phoneNumbers[0],
                2, 2, "5678", "");
            System.out.print(result);
        } catch (HTTPException e) {
           
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        
        try {
           
            int maxNum = 10;  
            SmsStatusPuller spuller = new SmsStatusPuller(appid, appkey);

            
            SmsStatusPullCallbackResult callbackResult = spuller.pullCallback(maxNum);
            System.out.println(callbackResult);

           
            SmsStatusPullReplyResult replyResult = spuller.pullReply(maxNum);
            System.out.println(replyResult);
        } catch (HTTPException e) {
           
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

      
        try {
            int beginTime = 1511125600;  
            int endTime = 1511841600;    
            int maxNum = 10;             
            SmsMobileStatusPuller mspuller = new SmsMobileStatusPuller(appid, appkey);

            
            SmsStatusPullCallbackResult callbackResult = mspuller.pullCallback("86",
                phoneNumbers[0], beginTime, endTime, maxNum);
            System.out.println(callbackResult);

            
            SmsStatusPullReplyResult replyResult = mspuller.pullReply("86",
                phoneNumbers[0], beginTime, endTime, maxNum);
            System.out.println(replyResult);
        } catch (HTTPException e) {
            
            e.printStackTrace();
        } catch (JSONException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }
}*/
