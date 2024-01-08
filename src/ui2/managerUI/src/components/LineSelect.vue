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
                        选择
                        </el-button>   
                </div>
            </template>
        </el-table-column>
    </el-table>
    <button @click="addFood">12</button>
</template>
<script setup>
import {ref,onMounted} from 'vue';
import {useRouter} from 'vue-router'
import {getAllLine} from '@/api/prodLine.js'
import {useStore} from 'vuex'

let store = useStore()

let router = useRouter()

const prodLines = ref([])


let prodLine = {
    "lineId":"1",
    "state":"1", 
    "name":"1",
}


const handleEdit = (index,row) => {
    store.dispatch("SELECT_LINE",row.lineId)
    router.push({name:"lotAdd",params:{'selectLine': row}})
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
    return {prodLines}
})

</script>