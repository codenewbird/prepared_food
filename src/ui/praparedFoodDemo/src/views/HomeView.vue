<template>
  <div class="header"><h1 align="center">XXX系统</h1> 
    <span @click="open('home')">首页</span>
    <span>|</span>
    <span @click="open('monitor')">监测</span>   
  </div>
  <HomeLeftView/>
  <HomeMiddleView/>
  <HomeRightView/>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue';
import {useRouter} from "vue-router"
import  HomeLeftView from '@/components/HomeLeftView.vue';
import  HomeMiddleView from '@/components/HomeMiddleView.vue';
import  HomeRightView from '@/components/HomeRightView.vue';

let router = useRouter();
const open = function(name){
    router.push({name: name})
};

</script>

<style scope>
.left{
  float: left;
  width: 33%;
}
.middle{
  float: left;
  width: 33%;
}
.right{
  float: left;
  width: 33%;
}
</style>
