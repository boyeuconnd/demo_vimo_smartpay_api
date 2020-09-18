package payment_gateway.channel.smart_pay.req;

import java.io.Serializable;

public class QueryRefundReq extends BaseReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String channel;

    private String refundId;

    private String transId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }
}
