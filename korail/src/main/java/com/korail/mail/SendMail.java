package com.korail.mail;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SendMail {
	
    public String makeSignature() {
        String space = " ";  // ����
        String newLine = "\n";  // �ٹٲ�
        String method = "POST";  // HTTP �޼ҵ�
        String url = "/api/v1/mails";  // �������� ������ "/" �Ʒ� ��ü url (������Ʈ�� ����)
        String timestamp = String.valueOf(System.currentTimeMillis());  // ���� Ÿ�ӽ����� (epoch, millisecond)
        String accessKey = "0uEcbsR4C2KcgwNEdYDT";  // access key id (from portal or sub account)
        String secretKey = "s03q7JwtXqvRTqJDgRJ3Ld91Zs0wb9p30aVxTT5b";  // secret key (from portal or sub account)

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            String encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

            return encodeBase64String;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}