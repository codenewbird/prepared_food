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
  <div class="header"><h1 align="center">安心食材&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一链追溯</h1> 
    <span @click="open('home')">首页</span>
    <span>|</span>
    <span @click="open('monitor')">监测</span>   
    <span>|</span>
    <span @click="open('workprocedure')">制作流程</span>  
    <span>|</span>
    <span @click="open('rawmaterial')">原料数据</span>   
    <span>|</span>
    <span @click="open('transportinfo')">存储运输</span>   

  </div>
<div class="query">
  <el-input style="width: 380px; float: left; " v-model="input" placeholder="Please input" />
  <el-button style="" class="submit" type="primary">Primary</el-button>
</div>
  <RouterView />
</template>

<style scoped>
  .query{
    display: flex;
    justify-content: center; 
  }
</style>