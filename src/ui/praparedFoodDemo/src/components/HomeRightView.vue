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
</template>

<script setup>
import { onMounted, ref} from 'vue'
import { getRawMaterial } from '@/api/product.js'

let tableData = ref([])

onMounted(async () => {
    try {
        await getRawMaterial().then(res => {
          tableData.value = res.data.map(obj => {
            return {
               name: obj.name,
               origin: obj.origin,
               storage: obj.storage,
               vendor: obj.vendor
            };
          });
        })
    } catch (error) {
        
    }
    return {tableData}
  })

</script>