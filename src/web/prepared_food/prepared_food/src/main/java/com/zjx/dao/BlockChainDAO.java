package com.zjx.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zjx.config.ResTemplateConfig;
import com.zjx.constant.BlockChainAPI;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class BlockChainDAO {
    @Resource
    private RestTemplate restTemplate;
    public Integer getBLKCHeight() throws JsonProcessingException {
        String url = BlockChainAPI.GET_BLOCK_CHAIN_HEIGHT;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseEntity.getBody());
        Integer height = node.get("Data").asInt();
        return height;
    }

}
