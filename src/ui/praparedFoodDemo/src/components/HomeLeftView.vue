<template>
    <div class="left">
        <h3>产品信息</h3>
        <div class="productInfo" style="border: 1px solid grey; margin: 10px; clear: both; background-color: #eeeeee20">
          <div style="width:50%; display:inline-block;">
            <ul type="none">
              <li>产品名称:</li>
              <li>产品批次:</li>
              <li>产品生产日期:</li>
              <li>产品保质期:</li>
              <li>产品来源:</li>
              <li>产品描述:</li>
            </ul>
          </div>
          <div style=" width:50%; display:inline-block;">
            <ul type="none">
              <li  v-for="(value, key) in baseInfo" :key="key">{{value}}</li>
            </ul>
          </div>
        </div>
        <h3>产品评论</h3>
        <div class="productInfo" style="border: 1px solid grey; margin: 10px; clear: both; ">
          <div style="width:50%; display:inline-block;" >
            <ul type="none">
              <li>产品名称:</li>
              <li>产品批次:</li>
              <li>产品生产日期:</li>
              <li>产品保质期:</li>
              <li>产品来源:</li>
              <li>产品描述:</li>
            </ul>
          </div>
          <div style="width:50%; display:inline-block;">
            <ul type="none">
              <li>产品名称:</li>
              <li>产品批次:</li>
              <li>产品生产日期:</li>
              <li>产品保质期:</li>
              <li>产品来源:</li>
              <li>产品描述:</li>
            </ul>
          </div>
        </div>
      </div>
</template>

<script setup>
import { ref,onMounted } from 'vue'
import { test3 } from '@/api/product.js'

let baseInfo = ref()


onMounted(async () => {
    try {
        await test3().then(res => {
          console.log(res.data)
          baseInfo.value = res.data;
        })
    } catch (error) {
        
    }
    return {baseInfo}
  })

</script>

<style>
  li{
    margin: 10px 10px;
  }
</style>
