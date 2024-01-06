
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
        <input type="checkbox" v-model="foodInfo.rawMaterialRule.isCheckTem" placeholder="1">检测温度
        <input type="checkbox" v-model="foodInfo.rawMaterialRule.isCheckHum" placeholder="1">检测湿度
        <input type="checkbox" v-model="foodInfo.rawMaterialRule.isCheckOxy" placeholder="1">检测含氧量
        <div v-if="foodInfo.rawMaterialRule.isCheckTem">
            <input type="text" v-model="foodInfo.rawMaterialRule.maxTem" placeholder="最大温度">
            <input type="text" v-model="foodInfo.rawMaterialRule.minTem" placeholder="最低温度">
        </div>
        <div v-if="foodInfo.rawMaterialRule.isCheckHum">
            <input type="text" v-model="foodInfo.rawMaterialRule.maxHum" placeholder="最大湿度">
            <input type="text" v-model="foodInfo.rawMaterialRule.minHum" placeholder="最低湿度">   
        </div>
        <div v-if="foodInfo.rawMaterialRule.isCheckOxy">
            <input type="text" v-model="foodInfo.rawMaterialRule.maxOxy" placeholder="最大含氧量">
            <input type="text" v-model="foodInfo.rawMaterialRule.minOxy" placeholder="最低含氧量">
        </div>
         
        
    </form>  
    <button @click="test1()">提交</button>  
    <div>  
            <h2>步骤录入</h2>  
            <button @click="addStep()">添加步骤</button>  
            <div v-for="(procedure, index) in procedures" :key="index">  
                <h3>步骤{{ index + 1 }}</h3>  
                <input type="text" placeholder="制作过程序号" v-model="procedure.rank">  <br>
                <input type="text" placeholder="制作过程描述" v-model="procedure.description">  <br>
                <input type="text" placeholder="监测点id" v-model="procedure.monitorPointId">  <br>
                <!-- 其他表单元素 -->  
                <button @click="removeStep(index)">删除步骤</button>  
            </div>  
        </div> 
</template>

<script setup>
import { ref,isRef } from 'vue'
import { test,add } from '@/api/food.js'

const procedures = ref([])

let addStep = function addStep() {  
      this.procedures.push({
            "identificationCode": "1",
            "rank":0,
            "description": "",
            "monitorPointId": ""
            }); // 初始化为空字符串或其他默认值  
    }
let removeStep = function removeStep(index) {  
      this.procedures.splice(index, 1); // 从数组中删除指定索引的元素  
    }  

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
        "procedures":procedures,
        "rawMaterialRule":{
            "identificationCode":"1",
            "isCheckTem":false,
            "isCheckHum":false,
            "isCheckOxy":false,
            "maxTem":"",
            "minTem":"",
            "maxHum":"",
            "minHum":"",
            "maxOxy":"",
            "minOxy":""
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

