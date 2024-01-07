package com.zjx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommentClassifyInterface {

    /*
     * 进行post请求
     */
    public static int postText (String text, String u) {
        String json = query(text,u);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode response = mapper.readTree(json);
            String code = String.valueOf(response.get("Code"));

            /*
             * code=200，请求成功
             * 判断是积极还是消极
             */
            if(code.equals("200") ) {
                JsonNode data = response.get("Data");
                String[] labels = mapper.readValue(String.valueOf(data.get("labels")), String[].class);
                if(labels[0].equals("正面")) return 1;
                else if(labels[0].equals("负面")) return -1;
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * 进行查询请求，根据url发送
     * 返回查询结果的json字符串
     */
     static String query(String text,String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Charset", "UTF-8");
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("Authorization", "Bearer 4505e0c1-e1ea-4be3-92be-02bf5cc9d45b");
        
            con.setConnectTimeout(5000);
            con.setDoInput(true);
            con.setDoOutput(true);
        
            String payload = text;
        
            try (OutputStream outputStream = con.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }
        
            try (InputStream inputStream = con.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
        
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
        
                return result.toString();
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}


class SentimentAnalysis {

    public static void main(String[] args) {
        String apiUrl = "https://api-inference.modelscope.cn/api-inference/v1/models/damo/nlp_structbert_sentiment-classification_chinese-ecommerce-base";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to POST
            connection.setRequestMethod("POST");
            
            // Set the request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer 4505e0c1-e1ea-4be3-92be-02bf5cc9d45b");

            // Enable input/output streams
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Create JSON payload
            String payload = "{\"input\": \"启动的时候很大声音，然后就会听到1.2秒的卡察的声音，类似齿轮摩擦的声音\"}";

            // Send the request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // Parse and print the response
                System.out.println(response.toString());
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}