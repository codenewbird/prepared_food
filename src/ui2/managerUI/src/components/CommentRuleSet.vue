<template>
    <input v-model="rule.hourMax" placeholder="时阈值"><br>
    <input v-model="rule.dayMax" placeholder="天阈值"><br>
    <input v-model="rule.monthMax" placeholder="月阈值"><br>
</template>

<script setup>
import {ref} from 'vue'
const rule = ref({
    "hourMax": "",
    "dayMax": "",
    "monthMax":""
})
</script>