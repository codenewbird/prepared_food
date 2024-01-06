<template>
    <input type="text" placeholder="生产线标号" v-model="prodLine.lineId"><br>
    <input type="text" placeholder="生产线状态" v-model="prodLine.state"><br>
    <input type="text" placeholder="生产线名称" v-model="prodLine.name"><br>
    <div>  
            <h2>设备录入</h2>  
            <button @click="addEquipment()">添加设备</button>  
            <div v-for="(equipment, index) in equipments" :key="index">  
                <h3>设备{{ index + 1 }}</h3>  
                <input type="text" placeholder="设备编号" v-model="equipment.equipmentId">  <br>
                <input type="text" placeholder="设备名称" v-model="equipment.name">  <br>
                <input type="text" placeholder="设备型号" v-model="equipment.model">  <br>
                <input type="text" placeholder="设备功能" v-model="equipment.feature">  <br>
                <input type="text" placeholder="制作厂商" v-model="equipment.manufacturer">  <br>
                <input type="date" placeholder="制造日期" v-model="equipment.manufacturerDate">  <br>
                <input type="date" placeholder="最后检修日期" v-model="equipment.latestOverhaulDate">  <br>
                <!-- 其他表单元素 -->  
                <button @click="removeEquipment(index)">删除设备</button>  
            </div>  
        </div>
    <button @click="add">提交</button>
    </template>
    <script setup>
    import {ref,onMounted} from 'vue';
    import {addLine} from '@/api/prodLine.js'
    
    let add = function add(){
        addLine(prodLine.value).then(res=>{
            console.log(res)
        })
    }
    


    const equipments = ref([])

    const prodLine = ref({
        "lineId":"",
        "state":"",
        "name":"",
        "equipments": equipments
    })

    let equipment = {
        "lineId":"1",
        "equipmentId":"",
        "name":"",
        "model":"",
        "feature":"",
        "manufacturer":"",
        "manufacturerDate":"",
        "latestOverhaulDate":"" 
    }

    let addEquipment = function (){
        this.equipments.push(equipment)
    }

    let removeEquipment = function remove(index){
        this.equipments.splice(index,1)
    }
    

    
    </script>