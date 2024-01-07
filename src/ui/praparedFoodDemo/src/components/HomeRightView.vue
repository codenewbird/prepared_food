<template>
    <div class="right">
        <div class="raw_material">
          <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="name" label="原料名称" width="180" />
            <el-table-column prop="origin" label="产地" width="180" />
            <el-table-column prop="storage" label="储存方式" />
            <el-table-column prop="vendor" label="生产商" />
          </el-table>
        </div>
      </div>
      <div style="margin-top: 400px; width: 100%; height: auto">
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
</template>

<script setup>
import { onMounted, ref} from 'vue'
import { getRawMaterial } from '@/api/product.js'

let tableData = ref([])

// onMounted(async () => {
//     try {
//         await getRawMaterial().then(res => {
//           tableData.value = res.data.map(obj => {
//             return {
//                name: obj.name,
//                origin: obj.origin,
//                storage: obj.storage,
//                vendor: obj.vendor
//             };
//           });
//         })
//     } catch (error) {
        
//     }
//     return {tableData}
//   })

</script>