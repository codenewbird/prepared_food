<template>
    <div class="select">
        <!-- <el-select v-model="seletedValue" placeholder="">
          <el-option :label="potato" :value="potato">potato</el-option>
          <el-option :label="beef" :value="beef">beef</el-option>
          <el-option :label="pepper" :value="pepper">pepper</el-option>
        </el-select> -->
        <el-select v-model="name" placeholder="" @change="$forceUpdate();selectedRaw=raw">
          <el-option v-for="raw in rawList" :label="raw.name" :value="raw.id" :key="raw.id"></el-option>
        </el-select>
    </div>
    <div class="list">
        <div class="raw_material">
          <el-table :data="selectedRaw" style="width: 100%">
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