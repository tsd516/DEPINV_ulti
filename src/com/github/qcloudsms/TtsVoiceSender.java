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


public class TtsVoiceSender extends SmsBase {

    private String url = "https://cloud.tim.qq.com/v5/tlsvoicesvr/sendtvoice";

    public TtsVoiceSender(int appid, String appkey) {
        super(appid, appkey, new DefaultHTTPClient());
    }

    public TtsVoiceSender(int appid, String appkey, HTTPClient httpclient) {
        super(appid, appkey, httpclient);
    }

    /**
     * 指定模板发???语音短???
     *
     * @param nationCode  国家码，???86为中???
     * @param phoneNumber  不带国家码的手机???
     * @param templateId  信息内容
     * @param params  模板参数列表
     * @param playtimes  播放次数
     * @param ext  扩展字段，原样返???
     * @return {@link}TtsVoiceSenderResult
     * @throws HTTPException  http status exception
     * @throws JSONException  json parse exception
     * @throws IOException    network problem
     */
    public TtsVoiceSenderResult send(String nationCode, String phoneNumber,
        int templateId, ArrayList<String> params,
        int playtimes, String ext)
            throws HTTPException, JSONException, IOException {

        long random = SmsSenderUtil.getRandom();
        long now = SmsSenderUtil.getCurrentTime();
        JSONObject body = new JSONObject()
            .put("tel", (new JSONObject()).put("nationcode", nationCode).put("mobile", phoneNumber))
            .put("tpl_id", templateId)
            .put("params", params)
            .put("playtimes", playtimes)
            .put("sig", SmsSenderUtil.calculateSignature(this.appkey, random, now, phoneNumber))
            .put("time", now)
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
            return (new TtsVoiceSenderResult()).parseFromHTTPResponse(res);
        } catch(URISyntaxException e) {
            throw new RuntimeException("API url has been modified, current url: " + url);
        }
    }

    public TtsVoiceSenderResult send(String nationCode, String phoneNumber,
        int templateId, String[] params,
        int playtimes, String ext)
            throws HTTPException, JSONException, IOException {

        return send(nationCode, phoneNumber, templateId,
            new ArrayList<String>(Arrays.asList(params)), playtimes, ext);
    }
}
