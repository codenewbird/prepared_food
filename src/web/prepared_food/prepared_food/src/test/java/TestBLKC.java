import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.dao.BlockChainDAO;
import com.zjx.entity.*;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class TestBLKC {
    final Base64.Encoder encoder = Base64.getEncoder();
    @Test
    public void test1() throws JsonProcessingException {
        List<Ingredient> list = new ArrayList<>();
        list.add(new Ingredient("123","食用油","XXX1配料公司",500f,new Date()));
        list.add(new Ingredient("123","鸡精","XXX2配料公司",400f,new Date()));
        list.add(new Ingredient("123","食用盐","XXX3配料公司",600f,new Date()));
        list.add(new Ingredient("123","糖","XXX4配料公司",100f,new Date()));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        json = encoder.encodeToString(json.getBytes());
        System.out.println(json);

    }
    @Test
    public void test2() throws JsonProcessingException {
        List<Nutrition.NutritionComposition> list = new ArrayList<>();
        list.add(new Nutrition.NutritionComposition("蛋白质",500f));
        list.add(new Nutrition.NutritionComposition("脂肪",1000f));
        list.add(new Nutrition.NutritionComposition("碳水化合物",2000f));
        list.add(new Nutrition.NutritionComposition("钠",50f));
        Nutrition nutrition = new Nutrition("123",list,"XX机构",new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(nutrition);
        json = encoder.encodeToString(json.getBytes());
        System.out.println(json);

    }
    @Test
    public void test3() throws JsonProcessingException {
        List<RawMaterial> list = new ArrayList<>();
        list.add(new RawMaterial("123","土豆","XX销售公司","湖南长沙XX镇",new Date(),"仓储"));
        list.add(new RawMaterial("123","番茄","XX2销售公司","湖南长沙XX1镇",new Date(),"低温存储"));
        list.add(new RawMaterial("123","大蒜","XX3销售公司","湖南长沙XX2镇",new Date(),"仓储"));
        list.add(new RawMaterial("123","鸡蛋","XX4销售公司","湖南长沙XX3镇",new Date(),"低温存储"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        json = encoder.encodeToString(json.getBytes());
        System.out.println(json);

    }
    @Test
    public void test4() throws JsonProcessingException {
//        StorageRecordItem item = new StorageRecordItem("123","冷藏",new Date(),18f,0.24f,0.58f,1,"XX地XX仓库");
//        StorageRecordItem item = new StorageRecordItem("123","冷藏",new Date(),20f,0.20f,0.50f,0,"XX地XX仓库");
//        StorageRecordItem item = new StorageRecordItem("123","冷藏",new Date(),15f,0.30f,0.66f,2,"XX地XX仓库");
        StorageRecordItem item = new StorageRecordItem("123","冷藏",new Date(),23f,0.51f,0.16f,2,"运输中");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(item);
        System.out.println(json);
        json = encoder.encodeToString(json.getBytes());
        System.out.println(json);
    }

    @Test
    public void test5() throws JsonProcessingException {
        BaseInfo baseInfo = new BaseInfo("不会起菜名菜","123",new Date(),new Date(),"XX黑厂","应该不会试试就逝世。。。");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(baseInfo);
        System.out.println(json);
        json = encoder.encodeToString(json.getBytes());
        System.out.println(json);
    }
}
