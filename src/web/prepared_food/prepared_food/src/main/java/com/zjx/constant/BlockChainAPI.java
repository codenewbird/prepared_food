package com.zjx.constant;

public class BlockChainAPI {
    public final static String IP = "http://192.168.183.128:8888";
    public final static String GET_BLOCK_CHAIN_HEIGHT = IP + "/getheight";//get
    public final static String CREATE_TRANSACTION = IP + "/store";//post
    public final static String QUERY_TRANSACTION_DETAIL= IP + "/getstore?hash=";//get
}
