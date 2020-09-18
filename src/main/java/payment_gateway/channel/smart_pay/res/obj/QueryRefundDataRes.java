package payment_gateway.channel.smart_pay.res.obj;

public class QueryRefundDataRes{
    private String orderNo;
    private String transId;
    private String refundId;
    private String refundTransId;
    private String created;
    private Integer amount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundTransId() {
        return refundTransId;
    }

    public void setRefundTransId(String refundTransId) {
        this.refundTransId = refundTransId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
