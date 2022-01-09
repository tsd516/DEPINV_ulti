package com.github.qcloudsms;

import com.github.qcloudsms.httpclient.HTTPClient;
import com.github.qcloudsms.httpclient.HTTPException;
import com.github.qcloudsms.httpclient.HTTPMethod;
import com.github.qcloudsms.httpclient.HTTPRequest;
import com.github.qcloudsms.httpclient.HTTPResponse;
import com.github.qcloudsms.httpclient.DefaultHTTPClient;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;


public class SmsMultiSender extends SmsBase {

    private String url = "https://yun.tim.qq.com/v5/tlssmssvr/sendmultisms2";

    public SmsMultiSender(int appid, String appkey) {
        super(appid, appkey, new DefaultHTTPClient());
    }

    public SmsMultiSender(int appid, String appkey, HTTPClient httpclient) {
        super(appid, appkey, httpclient);
    }

  
    public SmsMultiSenderResult send(int type, String nationCode, ArrayList<String> phoneNumbers,
        String msg, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        long random = SmsSenderUtil.getRandom();
        long now = SmsSenderUtil.getCurrentTime();
        JSONObject body = new JSONObject();
        body.put("tel", toTel(nationCode, phoneNumbers))
            .put("type", type)
            .put("msg", msg)
            .put("sig", SmsSenderUtil.calculateSignature(appkey, random, now, phoneNumbers))
            .put("time", now)
            .put("extend", SmsSenderUtil.isNotEmpty(extend) ? extend : "")
            .put("ext", SmsSenderUtil.isNotEmpty(ext) ? ext : "");

        HTTPRequest req = new HTTPRequest(HTTPMethod.POST, this.url)
            .addHeader("Conetent-Type", "application/json")
            .addQueryParameter("sdkappid", this.appid)
            .addQueryParameter("random", random)
            .setConnectionTimeout(60 * 1000)
            .setRequestTimeout(60 * 1000)
            .setBody(body.toString());

        try {
            // May throw IOException and URISyntaxexception
            HTTPResponse res = httpclient.fetch(req);

            // May throw HTTPException
            handleError(res);

            // May throw JSONException
            return (new SmsMultiSenderResult()).parseFromHTTPResponse(res);
        } catch(URISyntaxException e) {
            throw new RuntimeException("API url has been modified, current url: " + url);
        }
    }

    public SmsMultiSenderResult send(int type, String nationCode, String[] phoneNumbers,
        String msg, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        return send(type, nationCode, new ArrayList<String>(Arrays.asList(phoneNumbers)),
                    msg, extend, ext);
    }

    
    public SmsMultiSenderResult sendWithParam(String nationCode, ArrayList<String> phoneNumbers,
        int templateId, ArrayList<String> params, String sign, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        long random = SmsSenderUtil.getRandom();
        long now = SmsSenderUtil.getCurrentTime();
        JSONObject body = new JSONObject()
            .put("tel", toTel(nationCode, phoneNumbers))
            .put("sign", sign)
            .put("tpl_id", templateId)
            .put("params", params)
            .put("sig", SmsSenderUtil.calculateSignature(appkey, random, now, phoneNumbers))
            .put("time", now)
            .put("extend", SmsSenderUtil.isNotEmpty(extend) ? extend : "")
            .put("ext", SmsSenderUtil.isNotEmpty(ext) ? ext : "");

        HTTPRequest req = new HTTPRequest(HTTPMethod.POST, this.url)
            .addHeader("Conetent-Type", "application/json")
            .addQueryParameter("sdkappid", this.appid)
            .addQueryParameter("random", random)
            .setConnectionTimeout(60 * 1000)
            .setRequestTimeout(60 * 1000)
            .setBody(body.toString());

        try {
            // May throw IOException and URISyntaxexception
            HTTPResponse res = httpclient.fetch(req);

            // May throw HTTPException
            handleError(res);

            // May throw JSONException
            return (new SmsMultiSenderResult()).parseFromHTTPResponse(res);
        } catch (URISyntaxException e) {
            throw new RuntimeException("API url has been modified, current url: " + url);
        }
    }

    public SmsMultiSenderResult sendWithParam(String nationCode, String[] phoneNumbers,
        int templateId, String[] params, String sign, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        return sendWithParam(nationCode, new ArrayList<String>(Arrays.asList(phoneNumbers)),
                             templateId, new ArrayList<String>(Arrays.asList(params)),
                             sign, extend, ext);
    }

    private ArrayList<JSONObject> toTel(String nationCode, ArrayList<String> phoneNumbers) {
        ArrayList<JSONObject> phones = new ArrayList<JSONObject>();
        for (String phoneNumber: phoneNumbers) {
            JSONObject phone = new JSONObject();
            phone.put("nationcode", nationCode);
            phone.put("mobile", phoneNumber);
            phones.add(phone);
        }
        return phones;
    }
}
