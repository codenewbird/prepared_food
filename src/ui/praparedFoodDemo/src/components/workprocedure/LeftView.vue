<template>
    <div style="width: 50%; float: left">
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
            配料信息
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
                <el-table :data="tableData2" style="width: 100%">
                    <el-table-column prop="name" label="设备名称" width="80px" />
                    <el-table-column prop="model" label="设备型号"  />
                    <el-table-column prop="feature" label="功能" width="80px" />
                    <el-table-column prop="manufacture_date" label="生产日期" width="180px" />
                    <el-table-column prop="manufacturer" label="生产商" />
                    <el-table-column prop="latest_overhaul_date" label="最后检修日期" />
                </el-table>
            </div>
            制作人员信息
            <div style="border: 1px solid black width: 100%; height: 200px; background-color: #eee">
                <el-table :data="tableData3" style="width: 100%">
              <el-table-column prop="employee_id" label="员工编号" width="180" />
                <el-table-column prop="name" label="员工姓名" width="180" />
                <el-table-column prop="health_state" label="员工健康状况" />
                <el-table-column prop="duty" label="职责" />
            </el-table>
            </div>

        </div>
    </div>
</template>

<script setup>
import { ref,onMounted } from 'vue'
import { getIngredient,getProductionLineInfo } from '@/api/product.js'

let tableData = ref([])
onMounted(async () => {
    try {
        await getIngredient().then(res => {
          console.log(res.data)
          tableData.value = res.data;
          for (let i = 0; i < tableData.value.length; i++) {  
            const item = tableData.value[i];  
            const manufactureDate = new Date(item.manufacture_date);  
            const formattedDate = manufactureDate.toLocaleString();  
            tableData.value[i].manufacture_date = formattedDate;  
            
            }
          
        })
    } catch (error) {
        
    }
    return {tableData}
  })

let tableData2 = ref([])
let tableData3 = ref([])
onMounted(async () => {
    try {
        await getProductionLineInfo().then(res => {
          tableData2.value = res.data.equipmentList;
          for (let i = 0; i < tableData2.value.length; i++) {  
            const item = tableData2.value[i];  
            const manufactureDate = new Date(item.manufacture_date);  
            const formattedDate = manufactureDate.toLocaleString();  
            tableData2.value[i].manufacture_date = formattedDate;  
        }
        for (let i = 0; i < tableData2.value.length; i++) {  
            const item = tableData2.value[i];  
            let manufactureDate = new Date(item.latest_overhaul_date);  
            let formattedDate = manufactureDate.toLocaleString();  
            tableData2.value[i].latest_overhaul_date = formattedDate;  
          }
          tableData3.value = res.data.employeeList;
          
        })
    } catch (error) {
        
    }
    return {tableData2,tableData3}
  })
</script>