package payment_gateway.channel.smart_pay.req;

import java.io.Serializable;

public class QueryOrderReq extends BaseReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String channel;

    private String orderNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
