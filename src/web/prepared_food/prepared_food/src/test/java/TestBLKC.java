import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.entity.Ingredient;
import com.zjx.entity.Nutrition;
import com.zjx.entity.RawMaterial;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBLKC {
    @Test
    public void test1() throws JsonProcessingException {
        Ingredient ingredient = new Ingredient("123","食用油","XXX配料公司",500f,new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ingredient);
        System.out.println(json);

    }
    @Test
    public void test2() throws JsonProcessingException {
        List<Nutrition.NutritionComposition> list = new ArrayList<>();
        list.add(new Nutrition.NutritionComposition("蛋白质",0.5f));
        Nutrition nutrition = new Nutrition("123",list,"XX机构",new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(nutrition);
        System.out.println(json);

    }
    @Test
    public void test3() throws JsonProcessingException {
        List<RawMaterial> list = new ArrayList<>();
        list.add(new RawMaterial("123","土豆","XX销售公司","湖南长沙XX镇",new Date(),"仓储"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);

    }
}
