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
                <el-table-column prop="date" label="Date" width="180" />
                <el-table-column prop="name" label="Name" width="180" />
                <el-table-column prop="address" label="Address" />
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
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
];
</script>