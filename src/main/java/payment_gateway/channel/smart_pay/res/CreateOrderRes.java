package payment_gateway.channel.smart_pay.res;

import payment_gateway.channel.smart_pay.res.obj.CreateOrderDataRes;

public class CreateOrderRes extends BaseRes {
    private CreateOrderDataRes data;

    private String code;

    public CreateOrderDataRes getData() {
        return data;
    }

    public void setData(CreateOrderDataRes data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
