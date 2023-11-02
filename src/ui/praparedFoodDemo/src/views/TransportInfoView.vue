<template>
    <p>transportinfo</p>
    <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="storage_mode" label="储存方式" width="180" />
            <el-table-column prop="time" label="记录时间" width="180" />
            <el-table-column prop="temperature" label="温度(C)" />
            <el-table-column prop="humidity" label="湿度" />
            <el-table-column prop="oxygen_content" label="含氧量" />
            <el-table-column prop="state" label="状态" />
            <el-table-column prop="location" label="当前地点" />
    </el-table>
</template>

<script setup>

import { ref,onMounted } from 'vue'
import { getStorageRecord } from '@/api/storage.js'
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
        await getStorageRecord().then(res => {
            console.log(res.data)
          tableData.value = res.data.map(obj => {  
            console.log(obj)
            return {  
                storage_mode: obj.storage_mode,  
                time: new Date(obj.time).toLocaleString(),  
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