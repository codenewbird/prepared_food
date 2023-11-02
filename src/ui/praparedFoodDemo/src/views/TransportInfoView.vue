<template>
    <p>transportinfo</p>
    <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="storage_mode" label="storage_mode" width="180" />
            <el-table-column prop="time" label="time" width="180" />
            <el-table-column prop="temperature" label="temperature" />
            <el-table-column prop="humidity" label="humidity" />
            <el-table-column prop="oxygen_content" label="oxygen_content" />
            <el-table-column prop="state" label="state" />
            <el-table-column prop="location" label="location" />
    </el-table>
</template>

<script setup>

import { ref,onMounted } from 'vue'
import { test } from '@/api/storage.js'
let tableData = ref([])

const fun1 = function (num) {
    switch (num) {
        case 0:
            return "在库中"
            break;
        case 1:
            return "入库"
            break;
        case 2:
            return "出库"
            break;
        case 3:
            return "运输中"
            break;
        default:
            break;
    }
}

onMounted(async () => {
    try {
        await test().then(res => {
            console.log(res.data)
          tableData.value = res.data.map(obj => {  
            console.log(obj)
            return {  
                storage_mode: obj.storage_mode,  
                time: obj.time,  
                temperature: obj.temperature,
                humidity: obj.humidity,
                oxygen_content: obj.oxygen_content,
                state: fun1(obj.state),
                location: obj.location
             }; })
          console.log(tableData.value)
        })
    } catch (error) {
        
    }
    return {tableData}
  })

</script>