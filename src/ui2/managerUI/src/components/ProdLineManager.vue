<template>
    <el-table :data="prodLines" style="width: 100%" @column-change="handleColumnChange">
        <el-table-column prop="lineId" label="生产线编号" width="180" />
        <el-table-column prop="name" label="生产线名称" width="180" />
        <el-table-column prop="state" label="生产线状态" />
        <el-table-column label="操作" width="300">
            <template #default="scope">
                <div>
                    <el-button
                        text
                        :icon="Edit"
                        @click="handleEdit(scope.$index, scope.row)"
                        v-permiss="15"
                        >
                        编辑
                        </el-button>
                    <el-popconfirm confirm-button-text="是" cancel-button-text="否" title="您确定删除吗？"
                        icon-color="#626AEF" @confirm="handleDelete(scope.$index,scope.row)">
                        <template #reference>
                            <el-button>删除</el-button>
                        </template>
                    </el-popconfirm>    
                                    
                </div>
            </template>
        </el-table-column>
    </el-table>
    <button @click="addFood">12</button>
</template>
<script setup>
import {ref,onMounted} from 'vue';
import {getAllLine} from '@/api/prodLine.js';
    

const prodLines = ref([])


let prodLine = {
    "lineId":"1",
    "state":"1", 
    "name":"1",
}

const handleDelete = (index,row) => {
console.log(index)
console.log(row)
};

const handleEdit = (index,row) => {
    console.log(index)
    console.log(row)
};
    
let addFood = function getAllFoods(){
    this.prodLines.push(prodLine)
}

  
onMounted(async ()=>{
    try{
        getAllLine().then(res =>{
            console.log(res)
            prodLines.value = res.data
        })
    }catch(error){

    }
    console.log(router.params.selectLine) 

    return {prodLines}
})

</script>