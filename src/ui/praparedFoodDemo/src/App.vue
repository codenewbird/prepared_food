<script setup>
import { RouterView } from 'vue-router'
import {useRouter} from "vue-router"
import { provide } from "vue";
import * as echarts from "echarts"
provide("echarts", echarts);
let router = useRouter();
const open = function(name){
    router.push({name: name})
};
</script>

<template>
  <div class="header"><h1 align="center">XXX系统</h1> 
    <span @click="open('home')">首页</span>
    <span>|</span>
    <span @click="open('monitor')">监测</span>   
    <span>|</span>
    <span @click="open('workprocedure')">制作流程</span>  
    <span>|</span>
    <span @click="open('rawmaterial')">原料数据</span>   
    <span>|</span>
    <span @click="open('transportinfo')">存储运输</span>   
    <span>|</span>
    <span @click="open('saleinfo')">销售数据</span>    
  </div>
  <RouterView />
</template>
