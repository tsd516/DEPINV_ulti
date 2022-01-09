
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
        String[] phoneNumbers = {"15067501763"}; //�ֻ��ſ�����ܶࡣ
        int templateId = 1084576;
        String smsSign = "̥����������Ů��������Ԥ";
        try {
            String[] params = {"1231"};  //��һ����������{1}λ����Ҫ�����ݣ��ڶ�������{2}�����ݣ��Դ����ơ����忴����5
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
        String reStr = ""; //���巵��ֵ
        // ����Ӧ��SDK AppID  1400��ͷ
        int appid = 1400009099 ;
        // ����Ӧ��SDK AppKey
        String appkey = "2b49cd1b64b8d0de9f51c67c43b193cd";
        // ����ģ��ID����Ҫ�ڶ���Ӧ��������
        int templateId = 1084576 ;
        // ǩ����ʹ�õ���ǩ�����ݣ�������ǩ��ID
        String smsSign = "̥����������Ů��������Ԥ";
        //���������λ��֤��Ĺ�����
        String code = keyUtil.keyUtils();
        try {
            //������һ��Ҫ��Ӧ����ģ���еĲ���˳��͸�����
            String[] params = {code};
            //����ssender����
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //����
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,templateId, params, smsSign, "", "");
            if(result.result!=0){
                reStr = "error";
            }
            // ǩ������δ�ṩ����Ϊ��ʱ����ʹ��Ĭ��ǩ�����Ͷ���
            HttpSession session = request.getSession();
            //JSONObject��������
            JSONObject json = new JSONObject();
            json.put("Code", code);//������֤��
            json.put("createTime", System.currentTimeMillis());//���뷢�Ͷ�����֤���ʱ��
            // ����֤��Ͷ��ŷ���ʱ�������SESSION
            request.getSession().setAttribute("MsCode", json);
            reStr = "success";
        } catch (HTTPException e) {
            // HTTP��Ӧ�����
            e.printStackTrace();
        } catch (JSONException e) {
            // json��������
            e.printStackTrace();
        } catch (IOException e) {
            // ����IO����
            e.printStackTrace();
        }catch (Exception e) {
            // ����IO����
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

       
        String smsSign = "̥����������Ů��������Ԥ";

      
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                "����Ѷ�ơ�������֤����: 1231", "", "");
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
