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
        <div class="productInfo" style="border: 1px solid grey; margin: 50px auto; clear: both; background-color: #eeeeee20">
          <div style="padding: 20px" v-for="(comment,index) in comments" key="index">
            <p></p>
          </div>
          <el-input
              v-model="textarea"
              :rows="2"
              placeholder="点评一下"
              style="float: left; width: 430px"
            />
          <el-button style="" class="submit" type="primary" display="inline-block">发表评论</el-button>

        </div>
      </div>
</template>

<script setup>
import { ref,onMounted } from 'vue'
import { getBaseInfo } from '@/api/product.js'

let baseInfo = ref()

let comments = ref([])

const comment = {
  userId: "",
  nickName: "",
  content: ""
}

// onMounted(async () => {
//     try {
//         await getBaseInfo().then(res => {
//           console.log(res.data)
//           baseInfo.value = res.data;
//           baseInfo.value.manufacture_date = new Date(baseInfo.value.manufacture_date).toLocaleString();
//           baseInfo.value.shelf_life = new Date(baseInfo.value.shelf_life).toLocaleString();
//         })
//     } catch (error) {
        
//     }
//     return {baseInfo}
//   })

</script>

<style>
  li{
    margin: 10px 10px;
  }
</style>
