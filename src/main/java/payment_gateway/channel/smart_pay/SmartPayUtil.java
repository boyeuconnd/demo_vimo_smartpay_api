package payment_gateway.channel.smart_pay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SmartPayUtil {

    public static String getRequestId(){
        Random random = new Random();

        String sb = "VM";
        sb += String.format("%04d",random.nextInt(10000));
        sb += new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return sb;
    }

    public static String getCreateTime(){
        Date date = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatterDate.format(date);
    }

    public static String getBillNumber(){
        String billNo = "Vimo";
        billNo += new SimpleDateFormat("MMddHHmmss").format(new Date());
        return billNo;
    }
}
