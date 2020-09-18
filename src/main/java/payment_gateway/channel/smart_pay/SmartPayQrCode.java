package payment_gateway.channel.smart_pay;

import com.fasterxml.jackson.databind.ObjectMapper;
import payment_gateway.channel.smart_pay.req.*;
import payment_gateway.channel.smart_pay.res.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SmartPayQrCode {

    private SmartPayQrCode(){}

    public static synchronized SmartPayQrCode getInstance(){
        SmartPayQrCode smartPayQrCode = null;
        if(smartPayQrCode == null){
            return new SmartPayQrCode();
        }
        return smartPayQrCode;
    }
    public String createOrder(String description,Integer amount) throws IOException, NoSuchAlgorithmException {
        CreateOrderReq req = new CreateOrderReq();

        req.setChannel(SmartPayConstants.CHANNEL_CODE);
        req.setMerchantId(SmartPayConstants.MERCHANT_ID); // Get MerchantId
        req.setBranchCode(SmartPayConstants.BRANCH_CODE);
        req.setDesc(description);
        req.setOrderNo(SmartPayUtil.getRequestId());
        req.setExtras("extra information");
        req.setAmount(amount);
        req.setRequestType(SmartPayConstants.REQUEST_TYPE);
        req.setNotifyUrl(SmartPayConstants.NOTIFY_URL);
        req.setCreated(SmartPayUtil.getCreateTime());

        return process(req,SmartPayUtil.getRequestId(),SmartPayConstants.CREATE_QR, CreateOrderRes.class);
    }

    public String queryOrder(String billNo) throws IOException, NoSuchAlgorithmException {
        QueryOrderReq req = new QueryOrderReq();

        req.setChannel(SmartPayConstants.CHANNEL_CODE);
        req.setOrderNo(billNo);
        req.setCreated(SmartPayUtil.getCreateTime());
        return process(req,SmartPayUtil.getRequestId(),SmartPayConstants.QUERY_ORDER, QueryOrderRes.class);

    }

    public String refund(String orderNo,Integer amount,String transId,String description)
            throws IOException, NoSuchAlgorithmException {
        RefundReq req = new RefundReq();

        req.setChannel(SmartPayConstants.CHANNEL_CODE);
        req.setDesc(description);
        req.setOrderNo(orderNo);
        req.setRefundId(SmartPayUtil.getRequestId());
        req.setAmount(amount);
        req.setTransId(transId);
        req.setCreated(SmartPayUtil.getCreateTime());

        return process(req,SmartPayUtil.getRequestId(),SmartPayConstants.REFUND, RefundRes.class);

    }

    public String queryRefund(String refundId, String transId) throws IOException, NoSuchAlgorithmException {
        QueryRefundReq queryRefundReq = new QueryRefundReq();
        queryRefundReq.setChannel(SmartPayConstants.CHANNEL_CODE);
        queryRefundReq.setRefundId(refundId);
        queryRefundReq.setTransId(transId);
        return process(queryRefundReq,SmartPayUtil.getRequestId(),SmartPayConstants.CHECK_REFUND, QueryRefundRes.class);
    }

    private<T extends BaseRes> String process(BaseReq req, String requestId,String endPoint, Class<T> clazz)
            throws IOException, NoSuchAlgorithmException {

        String api_endpoint = SmartPayConstants.URL + endPoint;

        String res = ApiClient.callApi(req,requestId,api_endpoint);

        return res;

    }
}
