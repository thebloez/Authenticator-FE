package com.lab.fe.authenticator.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.Timestamp;
import java.util.Date;

public class Authenticator {

    private static final String HMAC_SHA256 = "HmacSHA256";

    public String generatorHMAC(String secretKey,
                                String apiKey,
                            String httpMethod,
                            String relativeUrl,
                            String requestBody,
                            String timeStamp) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ipLocal =  inetAddress.getHostAddress();
        requestBody = requestBody.replaceAll("\n","").replaceAll("\r","");

        //unused if (ipLocal.equals(IP_LOCAL)){

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        String hexRequestBody = DigestUtils.sha256Hex(requestBody);

        String requestData = httpMethod + ":" + relativeUrl + ":" + apiKey + ":" + hexRequestBody.toLowerCase() + ":"
                + timeStamp;
        try {
            return calculateHMAC(requestData, secretKey);
        } catch (SignatureException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        //unused } else { return "You're not allowed";}

        return null;
    }

    private static String calculateHMAC(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        return toHexString(mac.doFinal(data.getBytes()));
    }

    private static String toHexString(byte[] bytes) {
        //Formatter formatter = new Formatter();
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            //formatter.format("%02x", b);
            buffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return buffer.toString();
    }
}
