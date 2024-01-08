
<template>
    <form id="myForm">  
        <input type="text" placeholder="标识码" v-model="lot.identificationCode" @click="selectFood"> <br> 
        <input type="text" placeholder="生产批次号" v-model="lot.lot">   <br>
        <input type="text" placeholder="生产线" v-model="lot.lineId" @click="selectLine" readonly> <br>  
        <input type="text" placeholder="状态" v-model="lot.state">  <br>
        <input type="text" placeholder="生产数量" v-model="lot.num">  <br>             
    </form>  
    <button @click="test1()">提交</button>  
    <p>lot:{{$store.state.lot.lot}} </p>
</template>
 
<script setup>
import {useRouter} from "vue-router"
import { ref,isRef,onMounted } from 'vue'
import { addlot } from '@/api/lot.js'
import { useStore } from 'vuex'

let store = useStore()
let router = useRouter()

const lot = ref({
    "identificationCode":"1",
    "lot":"",
    "lineId":"",
    "state":"",
    "num":""
})

let selectLine = function select(){
    store.dispatch("BEFORE",lot.value)
    router.push({name:"lineSelect"})
}

let selectFood = function select2(){
    store.dispatch("BEFORE",lot.value)
    router.push({name: "foodSelect"})
}



let add = function add(){
    addlot.then(res=>{
        console.log(res)
    })
}

onMounted(()=>{
    // store.dispatch("RECOVERY_LOT").then(res=>{
    //     console.log(res.lot)
    //     if(res.lot){
    //         lot.value = res.lot 
    //     }
    // });
    lot.value = store.state.lot
})


</script>

