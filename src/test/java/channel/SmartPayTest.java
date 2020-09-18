package channel;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import payment_gateway.channel.smart_pay.SmartPayQrCode;
import payment_gateway.channel.smart_pay.res.CreateOrderRes;
import payment_gateway.channel.smart_pay.res.QueryOrderRes;
import payment_gateway.channel.smart_pay.res.QueryRefundRes;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class SmartPayTest {
    SmartPayQrCode smartPayQrCode = SmartPayQrCode.getInstance();
    ObjectMapper mapper = new ObjectMapper();


    @Test
    void testSimple(){
        int number = 1;
        int expect = 1;
        assertEquals(expect,number);
    }

    @Test
    void testCreateOrder(){
        String expectNot = "ZZZ";
        String output = null;
        String responseCode = null;
        try {
            output = smartPayQrCode.createOrder("description",60000);
            responseCode = mapper.readValue(output, CreateOrderRes.class).getCode();

            System.out.println("data: "+output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            assertNotEquals(expectNot,output);
            assertEquals(responseCode,"OK");
        }


    }

    @Test
    void testQueryOrder(){
        String expectNot = "ZZZ";
        String output = null;
        String responseCode = null;
        try {
            output = smartPayQrCode.queryOrder("Vimo08091149");
            responseCode = mapper.readValue(output, QueryOrderRes.class).getCode();
            System.out.println("data: "+output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            assertNotEquals(expectNot,output);
            assertEquals(responseCode,"OK");
        }
    }

    @Test
    void testRefund(){
        String invalidSignature = "ZZZ";
        String output = null;
        String transId ="20200908000000135";
        String orderNo = "Vimo08091258";
        Integer amount = 50000;
        try {
            output = smartPayQrCode.refund(orderNo,amount,transId,"TestRefund");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            assertNotEquals(invalidSignature,output);
        }
    }

    @Test
    void testQueryRefund(){
        String invalidSignature = "ZZZ";
        String output = null;
        String responseCode = null;

        final String transId = "VM33420200908130411";
        final String refundId = "20200908000000135";

        try {
            output = smartPayQrCode.queryRefund(transId, refundId);
            responseCode = mapper.readValue(output, QueryRefundRes.class).getCode();
            System.out.println("data: "+output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            assertNotEquals(invalidSignature,output);
            assertEquals("OK",responseCode);
        }
    }

}
