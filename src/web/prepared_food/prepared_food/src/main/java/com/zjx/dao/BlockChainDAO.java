package com.zjx.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.constant.BlockChainAPI;
import com.zjx.entity.Ingredient;
import com.zjx.entity.StorageRecordItem;
import com.zjx.pojo.StorageRecord;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Repository
public class BlockChainDAO {
    final Base64.Decoder bdecoder =  Base64.getDecoder();
    final Base64.Encoder bencoder = Base64.getEncoder();
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ProductDao productDao;
    @Resource
    private StorageDao storageDao;
    public Integer getBLKCHeight() throws JsonProcessingException {
        String url = BlockChainAPI.GET_BLOCK_CHAIN_HEIGHT;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseEntity.getBody());
        Integer height = node.get("Data").asInt();
        return height;
    }

    public String getBaseInfoByHash() throws UnsupportedEncodingException, JsonProcessingException {
        String hash = productDao.getHash("123").getBaseInfo_hash();
        String res = getJson(hash);
        return res;
    }

    public String getNutritionByHash() throws UnsupportedEncodingException, JsonProcessingException {
        String hash = productDao.getHash("123").getNutrition_hash();
        String res = getJson(hash);
        return res;
    }

    public String getRawMaterialByHash() throws UnsupportedEncodingException, JsonProcessingException {
        String hash = productDao.getHash("123").getRawMaterial_hash();
        String res = getJson(hash);
        return res;
    }

    public String getIngredientByHash() throws JsonProcessingException, UnsupportedEncodingException {
        String hash = productDao.getHash("123").getIngredient_hash();
        String res = getJson(hash);
        return res;
    }

    public String getStorageRecordList() throws UnsupportedEncodingException, JsonProcessingException {
        List<String> hashList = storageDao.getHash("123").stream().map(StorageRecord::getHashKey).toList();
        List<StorageRecordItem> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (String hash: hashList) {
            String json = getJson(hash);
            list.add(mapper.readValue(json, StorageRecordItem.class));
        }
        return mapper.writeValueAsString(list);
    }

    public String getJson(String hash) throws JsonProcessingException, UnsupportedEncodingException {
        hash = URLEncoder.encode(hash,"utf-8");
        String url = BlockChainAPI.QUERY_TRANSACTION_DETAIL+hash;
        String res = queryByUrl(url);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(res);
        String json = node.get("Data").asText();
        json = new String(bdecoder.decode(json.getBytes()), StandardCharsets.UTF_8);
        return json;
    }

    public String queryByUrl(String u){
        try{
            //URL url = new URL("https://blog.csdn.net/m0_46855648");//指定一个url
            URL url = new URL(u);//指定一个url

            HttpURLConnection con = (HttpURLConnection)url.openConnection();//强制转换，把URLConnection转换成HttpURLConnection

            con.setRequestMethod("GET");//设置请求方式是GET
            con.setConnectTimeout(5000);//设置链接超时
            con.setDoInput(true);//打开输入流
            con.setDoOutput(true);//打开输出流
            con.connect();//链接
            int code = con.getResponseCode();//获取服务器响应码
            System.out.println(code);//输出200，说明链接成功

            //测试链接成功后，开始读取指定url服务器的信息
            InputStream is = con.getInputStream();//使用URLConnection下的getInputStream()方法，返回打开的此链接读取的输入流
            InputStreamReader isr = new InputStreamReader(is,"utf-8");//设置编码格式为utf-8
            BufferedReader br = new BufferedReader(isr);
            //BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));//合并
            String text = null;
            String res = "";
            while ((text=br.readLine()) != null){//判断内容是否为空
                res += text;
            }
            br.close();//关闭流
            return res;
        }
        catch(SocketTimeoutException e){
            e.printStackTrace();
            return "";
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }/*catch(SocketTimeoutException e){//错误: 已捕获到异常错误
			e.printStackTrace();
		}*/
        //原因：代码的逻辑错误了。捕获异常的范围应该从小到大，这里IOException范围大于SocketTimeoutException，
        //因此捕捉异常直接走第一个IOException后就不会再走SocketTimeoutException了，把SocketTimeoutException放在
        //IOException上面就不会报错了
    }

}
