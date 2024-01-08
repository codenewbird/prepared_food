<template>
<el-table :data="foods" style="width: 100%" @column-change="handleColumnChange">
    <el-table-column prop="identificationCode" label="shelfLife" width="180" />
    <el-table-column prop="name" label="shelfLife" width="180" />
    <el-table-column prop="shelfLife" label="shelfLife" />
    <el-table-column prop="manufacturer" label="manufacturer" />
    <el-table-column prop="description" label="description" />
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
{{ $store.state.user.username }}
</template>
<script setup>
import {ref,onMounted} from 'vue';
import {getAllFoods} from '@/api/food.js'
import {useStore} from 'vuex'

let store = useStore();

const handleDelete = (index,row) => {
    console.log(index)
    console.log(row)
};

const handleEdit = (index,row) => {
    console.log(index)
    console.log(row)
};


const foods = ref([])
let food = {
    "identificationCode":"1",
    "name":"1",
    "shelfLife":"1",
    "manufacturer":"304",
    "description":"1"
}
let addFood = function getAllFoods(){
    this.foods.push(food)
}

onMounted(async ()=>{
    try{
        console.log("sercher")
        getAllFoods().then(res =>{
            foods.value = res.data
        })
    }catch(error){

    }
    return {foods}
})

</script>