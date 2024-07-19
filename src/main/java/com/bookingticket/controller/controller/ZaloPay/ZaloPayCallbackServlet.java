package com.bookingticket.controller.controller.ZaloPay;


import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet("/callback")
public class ZaloPayCallbackServlet extends HttpServlet {

    private static final String KEY2 = "eG4r0GcoNtRGbO8";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject result = new JSONObject();

        try {
            BufferedReader reader = req.getReader();
            String requestData = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            JSONObject requestDataJson = new JSONObject(requestData);

            String dataStr = requestDataJson.getString("data");
            String reqMac = requestDataJson.getString("mac");

            String calculatedMac = calculateHmacSHA256(dataStr, KEY2);

            if (!reqMac.equals(calculatedMac)) {
                // MAC không hợp lệ
                result.put("return_code", -1);
                result.put("return_message", "MAC not equal");
            } else {
                // Xử lý thanh toán thành công
                JSONObject dataJson = new JSONObject(dataStr);
                String appTransId = dataJson.getString("app_trans_id");
                System.out.println("Update order status: success for app_trans_id = " + appTransId);

                result.put("return_code", 1);
                result.put("return_message", "Success");
            }
        } catch (Exception e) {
            try {
                result.put("return_code", 0);
                result.put("return_message", e.getMessage());
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }

        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(result.toString());
    }

    private String calculateHmacSHA256(String data, String key) throws Exception {
        javax.crypto.spec.SecretKeySpec secretKey = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "HmacSHA256");
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] hmacData = mac.doFinal(data.getBytes());
        return Hex.encodeHexString(hmacData);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}
