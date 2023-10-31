<template>
  <HomeLeftView/>
  <HomeMiddleView/>
  <HomeRightView/>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue';
import  HomeLeftView from '@/components/HomeLeftView.vue';
import  HomeMiddleView from '@/components/HomeMiddleView.vue';
import  HomeRightView from '@/components/HomeRightView.vue';


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
