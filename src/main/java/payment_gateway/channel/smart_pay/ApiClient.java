package payment_gateway.channel.smart_pay;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import payment_gateway.channel.smart_pay.req.BaseReq;
import payment_gateway.channel.smart_pay.res.CreateOrderRes;
import payment_gateway.channel.smart_pay.res.QueryOrderRes;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class ApiClient {

    private final static int setTimeOutClient = 60000;
    private static ObjectMapper mapper = new ObjectMapper();
    private static Date date = new Date();

    public static String callApi(BaseReq baseRequest, String xRequestId,String url_endpoint ) throws IOException, NoSuchAlgorithmException {

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(setTimeOutClient)
                .setConnectTimeout(setTimeOutClient)
                .setSocketTimeout(setTimeOutClient)
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url_endpoint);
        String xTimeStamp = String.valueOf(date.getTime());

        String body = baseRequest != null ? mapper.writeValueAsString(baseRequest) : "";//Mapping Body Obj to JsonString

        String hashedContentBody = SmartPaySecurity.base64_SHA256(body);
        String requestBody = URLEncoder.encode(hashedContentBody, StandardCharsets.UTF_8.toString());

        //Create Signature
        String rawSignature = "requestId="+ xRequestId
                +"&caller="+SmartPayConstants.CHANNEL_CODE
                +"&timestamp="+xTimeStamp
                +"&requestBody="+requestBody
                +"&key="+SmartPayConstants.HASH_KEY;
        String xSignature = SmartPaySecurity.base64_SHA256(rawSignature);

        request.setConfig(config);
        request.addHeader("X-Caller",SmartPayConstants.CHANNEL_CODE);
        request.addHeader("X-Request-ID", xRequestId);
        request.addHeader("X-Timestamp", xTimeStamp);
        request.addHeader("X-Signature", xSignature);
        request.addHeader("Content-Type","application/json");

        if(baseRequest!=null){
            request.setEntity(new StringEntity(body));
        }

        HttpResponse response = httpClient.execute(request);

        //Verify Signature
        String xSignatureRes = response.getFirstHeader("x-signature").getValue();
//        System.out.println("X-Sign: "+xSignatureRes);

        String jsonRes = EntityUtils.toString(response.getEntity(),"UTF-8");
        if(!jsonRes.isEmpty()){

            String contentRes = SmartPaySecurity.base64_SHA256(jsonRes.replaceAll("(\\r\\n|\\n)",""));
            String hashedContentRes = URLEncoder.encode(contentRes,StandardCharsets.UTF_8.toString());


            String rawSignRes ="requestId="+xRequestId
                    +"&requestBody=" + hashedContentRes
                    +"&key=" + SmartPayConstants.HASH_KEY;

            String generateSignatureRes = SmartPaySecurity.base64_SHA256(rawSignRes);
//            System.out.println("GenerateSign: "+generateSignatureRes);
            if(!xSignatureRes.equals(generateSignatureRes)){
                return jsonRes = "ZZZ";
            }
        }
//        System.out.println(resposeCode);


        httpClient.close();
        return jsonRes;
    }

}
