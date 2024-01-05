import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.entity.*;
import org.junit.Test;

import java.util.Date;

public class TestBLK {
    @Test
    public void testFoodInfo() throws JsonProcessingException {
        BaseInfo baseInfo = new BaseInfo("1","八宝粥",new Date(),"304","不好喝","sq123");
        RawMaterial rawMaterial = new RawMaterial("1","红豆:20g;绿豆:40g");
        Ingredient ingredient = new Ingredient("1","糖:20g");
        Nutrition nutrition = new Nutrition("1","蛋白质:80%");
        Procedure procedure = new Procedure();
        FoodInfo foodInfo = new FoodInfo(baseInfo,rawMaterial,ingredient,nutrition,procedure);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(foodInfo);
        System.out.println(json);
    }
}
