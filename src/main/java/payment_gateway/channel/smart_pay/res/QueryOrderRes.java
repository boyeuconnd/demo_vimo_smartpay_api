package payment_gateway.channel.smart_pay.res;

import payment_gateway.channel.smart_pay.res.obj.QueryOrderDataRes;

import java.io.Serializable;

public class QueryOrderRes extends BaseRes implements Serializable {

    private QueryOrderDataRes data;

    private String code;

    public QueryOrderDataRes getData() {
        return data;
    }

    public void setData(QueryOrderDataRes data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
