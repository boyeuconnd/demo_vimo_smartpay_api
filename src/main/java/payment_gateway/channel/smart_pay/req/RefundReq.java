package payment_gateway.channel.smart_pay.req;

import payment_gateway.channel.smart_pay.res.BaseRes;

import java.io.Serializable;

public class RefundReq extends BaseReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String channel;
    private String desc;
    private String orderNo;
    private String refundId;
    private String transId;
    private Integer amount;
    private String created;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
