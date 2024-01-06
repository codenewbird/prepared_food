
<template>
    <form id="myForm">  
        <input type="text" placeholder="标识码" v-model="lot.identificationCode"> <br> 
        <input type="text" placeholder="生产批次号" v-model="lot.lot">   <br>
        <input type="text" placeholder="生产线" v-model="lot.lineId" readonly> <br>  
        <input type="text" placeholder="状态" v-model="lot.state">  <br>
        <input type="text" placeholder="生产数量" v-model="lot.num">  <br>             
    </form>  
    <button @click="test1()">提交</button>  
</template>
 
<script setup>
import {useRouter} from "vue-router"
import { ref,isRef } from 'vue'
import { addlot } from '@/api/lot.js'

router = useRouter()

let selectLine = function select(){
    router.push({name:"lineSelect"})
}

const lot = ref({
    "identificationCode":"1",
    "lot":"",
    "lineId":"",
    "state":"",
    "num":""
})

let add = function add(){
    addlot.then(res=>{
        console.log(res)
    })
}

</script>

