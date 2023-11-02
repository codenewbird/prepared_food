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

    @RequestMapping("getProductionLineInfo")
    public String getProductionLineInfo() throws JsonProcessingException, UnsupportedEncodingException {
        String productionLineInfo = blockChainDAO.getProductionLineInfoByHash();
        System.out.println(productionLineInfo);
        return productionLineInfo;
    }

    @RequestMapping("getBaseInfo")
    public String getBaseInfo() throws JsonProcessingException, UnsupportedEncodingException {
        String baseInfo = blockChainDAO.getBaseInfoByHash();
        System.out.println(baseInfo);
        return baseInfo;
    }
    @RequestMapping("getIngredient")
    public String getIngredient() throws JsonProcessingException, UnsupportedEncodingException {
        String ingredient = blockChainDAO.getIngredientByHash();
        System.out.println(ingredient);
        return ingredient;
    }
    @RequestMapping("getNutrition")
    public String getNutrition() throws JsonProcessingException, UnsupportedEncodingException {
        String nutrition = blockChainDAO.getNutritionByHash();
        System.out.println(nutrition);
        return nutrition;
    }
    @RequestMapping("getRawMaterial")
    public String getRawMaterial() throws JsonProcessingException, UnsupportedEncodingException {
        String rawMaterial = blockChainDAO.getRawMaterialByHash();
        System.out.println(rawMaterial);
        return rawMaterial;
    }
}
