<template>
    <div style="width: 50%">
        <div>
        <span>制作流程</span>
        <ul type="1">
            <li>原料清洗称重</li>
            <li>冷油入锅加热约2分钟</li>
            <li>油温适中时加入肉片炒约5分钟至半熟</li>
            <li>加入辣椒翻炒约30秒</li>
            <li>加入调味料调味约30秒</li>
            <li>出锅冷制封装</li>
        </ul>
        </div>
        <div>
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="name" label="配料名称" width="180" />
                <el-table-column prop="manufacture_date" label="生产日期" width="180" />
                <el-table-column prop="dosage" label="用量" />
                <el-table-column prop="manufacturer" label="生产商" />
            </el-table>
        </div>
        <div style="width: 100%">
            制作设备信息
            <div style="border: 1px solid black width: 100%; height: 200px; background-color: #eee">
                
            </div>
            制作人员信息
            <div style="border: 1px solid black width: 100%; height: 200px; background-color: #eee">
                
            </div>

        </div>
    </div>
</template>

<script setup>
import { ref,onMounted } from 'vue'
import { test4 } from '@/api/product.js'

let tableData = ref([])
onMounted(async () => {
    try {
        await test4().then(res => {
          console.log(res.data)
          tableData.value = res.data;
        })
    } catch (error) {
        
    }
    return {tableData}
  })
</script>