
<template>
    <form id="myForm">  
        <input type="text" placeholder="标识码" v-model="foodInfo.baseInfo.identificationCode"> <br> 
        <input type="text" placeholder="菜名" v-model="foodInfo.baseInfo.name">   <br>
        <input type="text" placeholder="保质期" v-model="foodInfo.baseInfo.shelfLife"> <br>  
        <input type="text" placeholder="生产商" v-model="foodInfo.baseInfo.manufacturer">  <br>
        <input type="text" placeholder="描述" v-model="foodInfo.baseInfo.description">  <br>
        <input type="text" placeholder="生产许可证编号" v-model="foodInfo.baseInfo.sqCode">  <br>
        <input type="text" placeholder="原材料" v-model="foodInfo.rawMaterial.detail">  <br>
        <input type="text" placeholder="配料" v-model="foodInfo.ingredient.detail">  <br>
        <input type="text" placeholder="营养" v-model="foodInfo.nutrition.detail">  <br>
        <input type="text" placeholder="制作过程序号" v-model="foodInfo.procedure.rank">  <br>
        <input type="text" placeholder="制作过程描述" v-model="foodInfo.procedure.description">  <br>
        <input type="text" placeholder="监测点id" v-model="foodInfo.procedure.monitorPointId">  <br>

         
        
    </form>  
    <button @click="test1()">提交</button>  
</template>

<script setup>
import { ref,isRef } from 'vue'
import { test,add,testPost } from '@/api/food.js'

const foodInfo = ref({
    "baseInfo":{
        "identificationCode":"1",
        "name":"八宝粥",
        "shelfLife":1704419707699,
        "manufacturer":"304",
        "description":"不好喝",
        "sqCode":"sq123"
        },
        "rawMaterial":{
            "identificationCode":"1",
            "detail":"红豆:20g;绿豆:40g"
            },
        "ingredient":{
            "identificationCode":"1",
            "detail":"糖:20g"
            },
        "nutrition":{
            "identificationCode":"1",
            "detail":"蛋白质:80%"
            },
        "procedure":{
            "identificationCode":"1",
            "rank":0,
            "description":"ok",
            "monitorPointId":"1"
            }
})


let test1 = function test2() {
    const jsonData = JSON.parse(JSON.stringify(foodInfo.value));  
    console.log(jsonData); // 输出JSON数据  
    add(jsonData).then(res =>{
        console.log(res);
    })
}
</script>

