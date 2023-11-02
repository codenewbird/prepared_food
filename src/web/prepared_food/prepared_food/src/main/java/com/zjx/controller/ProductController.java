package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjx.dao.BlockChainDAO;
import com.zjx.entity.Ingredient;
import com.zjx.entity.Nutrition;
import com.zjx.entity.RawMaterial;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class ProductController {
    @Resource
    private BlockChainDAO blockChainDAO;

    @RequestMapping("test3")
    public String getBaseInfo() throws JsonProcessingException, UnsupportedEncodingException {
        String baseInfo = blockChainDAO.getBaseInfoByHash();
        System.out.println(baseInfo);
        return baseInfo;
    }
    @RequestMapping("test4")
    public String getIngredient() throws JsonProcessingException, UnsupportedEncodingException {
        String ingredient = blockChainDAO.getIngredientByHash();
        System.out.println(ingredient);
        return ingredient;
    }
    @RequestMapping("test5")
    public String getNutrition() throws JsonProcessingException, UnsupportedEncodingException {
        String nutrition = blockChainDAO.getNutritionByHash();
        System.out.println(nutrition);
        return nutrition;
    }
    @RequestMapping("test6")
    public String getRawMaterial() throws JsonProcessingException, UnsupportedEncodingException {
        String rawmaterial = blockChainDAO.getRawMaterialByHash();
        System.out.println(rawmaterial);
        return rawmaterial;
    }
}
