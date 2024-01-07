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
                        选择
                        </el-button>   
                </div>
            </template>
        </el-table-column>
    </el-table>
</template>
<script setup>
import {ref,onMounted} from 'vue';
import {useRouter} from 'vue-router'
import {getAllFoods} from '@/api/food.js'

let router = useRouter()

const foods = ref([])


let food = {
        "identificationCode":"1",
        "name":"八宝粥",
        "shelfLife":1704419707699,
        "manufacturer":"304",
        "description":"不好喝",
        "sqCode":"sq123"
        }


const handleEdit = (index,row) => {
    console.log(row)
    router.push({name:"lotAdd",params:{'selectLine': row}})
};
    

  
onMounted(async ()=>{
    try{
        getAllFoods().then(res =>{

            foods.value = res.data
        })
    }catch(error){

    }
    return {foods}
})

</script>