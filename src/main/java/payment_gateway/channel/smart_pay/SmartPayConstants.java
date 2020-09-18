package payment_gateway.channel.smart_pay;

public class SmartPayConstants {
    //
    public static final String CHANNEL_CODE = "VMO";// Payment_Account.MerchantName
    public static final String CONTENT_TYPE = "application/json";
    public static final String MERCHANT_ID = "00000049"; // Payment_Account.MerchantId
    public static final String BRANCH_CODE = "Vimo1"; // Ma cua hang
    public static final String HASH_KEY = "Ack4d2yLcPazQsCaaAeMkBYamvW3ST66";//Payment_Account.Encrypt_key
    //
    public static final String URL = "https://sb-mch.paysmart.com.vn"; // Url
    public static final String CREATE_QR = "/v2.0/qr/createorder";
    public static final String QUERY_ORDER = "/v2.0/query/order";
    public static final String CHECK_ORDER = "/v2.0/check/order";
    public static final String REFUND = "/v2.0/refund";
    public static final String CHECK_REFUND = "/v2.0/check/refund";

    public static final String REQUEST_TYPE = "qrcode";
    public static final String NOTIFY_URL = "https://gateway-sandbox.vimo.vn/PaymentGatewayBilling/restful/apiVM/smartPayNotifyOrderStatus";
}
