package payment_gateway.channel.smart_pay.res;

import payment_gateway.channel.smart_pay.res.obj.RefundDataRes;

public class RefundRes extends BaseRes {
    private RefundDataRes data;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RefundDataRes getData() {
        return data;
    }

    public void setData(RefundDataRes data) {
        this.data = data;
    }
}
