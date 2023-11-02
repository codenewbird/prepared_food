<template>
    <div class="select">
        <el-select ref="rawRef" v-model="name" placeholder="请选择原料" @change="$forceUpdate(),toSelect()" value-key="id">
            <el-option v-for="raw in rawList" :label="raw.name" :value="raw" key="raw.id"></el-option>
        </el-select>
    </div>
    <div class="list">
        <div class="raw_material">
          <el-table :data="tableData" style="width: 100%">
            <!-- 呈现原料的列表 -->
            <el-table-column prop="name" label="原料名称" width="180" />
            <el-table-column prop="vendor" label="供应商" width="180" />
            <el-table-column prop="buy_time" label="购入时间" width="180"/>
            <el-table-column prop="origin" label="产地" width="180"/>
            <el-table-column prop="storage" label="储存方式" width="180"/>
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
          console.log(res.data)
          tableData.value = res.data;
          for (let i = 0; i < tableData.value.length; i++) {  
            const item = tableData.value[i];  
            const manufactureDate = new Date(item.buy_time);  
            const formattedDate = manufactureDate.toLocaleString();  
            tableData.value[i].buy_time = formattedDate;  
            }
        })
    } catch (error) {
        
    }
    return {tableData}
  })

const toSelect = () =>{
  //  this.$forceUpdate()
  // let obj = {}
  // obj = this.model.find(
  //   (item)=>{
  //     return item.id === id
  //   }
  // )
  // console.log("obj",obj)
  // console.log(
  //       this.$refs.rawRef.selected.value,
  //       this.$refs.rawRef.selected.label
  //     );
 };
</script>
