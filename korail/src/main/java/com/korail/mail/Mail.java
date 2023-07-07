package com.korail.mail;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mail {
	
	public static void main(String[] args) throws IOException {
        // API 엔드포인트
        String endpoint = "https://mail.apigw.ntruss.com/api/v1";

        // API 요청 바디
        String requestBody = "{"
                + "\"senderAddress\": \"Korail@test.com\","
                + "\"senderName\": \"It's me\","
                + "\"title\": \"Email Test\","
                + "\"body\": \"Email test\","
                + "\"individual\": ture,"
                + "\"confirmAndSend\": true,"
                + "\"advertising\": false,"
                + "\"parameters\": {},"
                + "\"recipients\": [{\"address\": \"kccz37@naver.com\"}, {\"address\": \"recipient2@example.com\"}]"
                + "}";

        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body: " + response.toString());
    }
	
    public String makeSignature() {
        String space = " ";  // 공백
        String newLine = "\n";  // 줄바꿈
        String method = "POST";  // HTTP 메소드
        String url = "/api/v1/mails";  // 도메인을 제외한 "/" 아래 전체 url (쿼리스트링 포함)
        String timestamp = String.valueOf(System.currentTimeMillis());  // 현재 타임스탬프 (epoch, millisecond)
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