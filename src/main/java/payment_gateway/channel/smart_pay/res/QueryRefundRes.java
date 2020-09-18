package payment_gateway.channel.smart_pay.res;

import payment_gateway.channel.smart_pay.res.obj.QueryRefundDataRes;

public class QueryRefundRes extends BaseRes {
    private String code;

    private QueryRefundDataRes[] data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public QueryRefundDataRes[] getData() {
        return data;
    }

    public void setData(QueryRefundDataRes[] data) {
        this.data = data;
    }
}
