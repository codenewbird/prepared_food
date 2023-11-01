<template>
    <div class="select">
        <el-select ref="rawRef" v-model="name" placeholder="请选择原料" @change="$forceUpdate(),toSelect()" value-key="id">
            <el-option v-for="raw in rawList" :label="raw.name" :value="raw" key="raw.id"></el-option>
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
const selectedRaw=[];
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