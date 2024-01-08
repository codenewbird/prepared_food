package controller.classify;

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
    public int postText (String text, String u) {
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
    String query(String text,String u) {
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