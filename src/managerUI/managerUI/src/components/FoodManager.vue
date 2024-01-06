<template>

<button @click="addFood">12</button>
</template>
<script setup>
import {ref} from 'vue'
const foods = ref([])
let food = {
    "identificationCode":"1",
    "name":"1",
    "shelfLife":"1",
    "manufacturer":"304",
    "description":"1"
}
let addFood = function addFood(){
    this.foods.push(food)
}
</script>