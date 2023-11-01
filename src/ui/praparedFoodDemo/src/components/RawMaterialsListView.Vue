<template>
    <div class="select">
        <el-select v-model="selectedValue" placeholder="choose raw material">
          <el-option :label="potato" :value="potato"></el-option>
          <el-option :label="beef" :value="beef"></el-option>
          <el-option :label="pepper" :value="pepper"></el-option>
          <!-- 此处接入数据库各项原料 -->
        </el-select>
        <el-select v-model="selectedRaw" placeholder="">
          <el-option v-for="raw in rawList" :label="rawList.name" :value="rawList.id"></el-option>
        </el-select>
    </div>
    <div class="list">
        <div class="raw_material">
          <el-table :data="tableData" style="width: 100%">
            <!-- 呈现原料的列表 -->
            <el-table-column prop="name" label="name" width="180" />
            <el-table-column prop="vender" label="vender" width="180" />
            <el-table-column prop="rating" label="rating" width="180"/>
          </el-table>
        </div>
      </div>
</template>

<script setup>
const tableData = [
  {
    name: 'potato',
    vender: 'XX COMPANY',
    rating: 'GOOD',
  },
];  
const selectedRaw="";
const rawList = [
  {
    name: 'potato',
    vender: 'XX COMPANY',
    rating: 'GOOD',
    id: 1,
  },
  {
    name: 'beef',
    vender: 'XX COMPANY',
    rating: 'GOOD',
    id: 2,
  },
  {
    name: 'pepper',
    vender: 'XX COMPANY',
    rating: 'GOOD',
    id: 3,
  },
];
</script>