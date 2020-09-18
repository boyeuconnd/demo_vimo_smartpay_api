
import com.fasterxml.jackson.databind.ObjectMapper;
import payment_gateway.channel.smart_pay.SmartPayQrCode;
import payment_gateway.channel.smart_pay.res.QueryOrderRes;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class HelloWorld {
    public static void main(String[] args) {
        SmartPayQrCode smartPayQrCode = SmartPayQrCode.getInstance();
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonRes = smartPayQrCode.refund("Vimo08091258",50000,"20200908000000135","Test Refund");

            if(jsonRes.equals("ZZZ")){
                System.out.println("Invalid Signature");

            }else {
                System.out.println("Valid Signature");
                System.out.println("data: "+jsonRes);
                QueryOrderRes queryOrderRes = mapper.readValue(jsonRes.replaceAll("(\\n)",""),QueryOrderRes.class);
                String resposeCode = queryOrderRes.getCode();
                System.out.println("Response Code: "+resposeCode);
            }
//            System.out.println(jsonRes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }




}

