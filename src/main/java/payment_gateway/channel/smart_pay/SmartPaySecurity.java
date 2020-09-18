package payment_gateway.channel.smart_pay;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SmartPaySecurity {

    protected  static String base64_SHA256(String rawData) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(rawData.getBytes(StandardCharsets.UTF_8));
        byte[] hashedByteArray = digest.digest();
        String result = Base64.getEncoder()
                .encodeToString(hashedByteArray)
                .replaceAll("(\\r\\n|\\n)","")
                .trim();
        return result;
    }
}
