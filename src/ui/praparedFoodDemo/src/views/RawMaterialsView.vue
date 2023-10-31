<template>
    <p>RawMaterial</p>
    <RawMaterialsListView/>
</template>

<script setup>
// import { defineConfig } from 'vite';
// import vue from '@vitejs/plugin-vue';
import { onMounted, ref, inject } from 'vue';
import RawMaterialsListView from '../components/RawMaterialsListView.Vue';

</script>

<style scope>
.list{
  float: left;
}
</style>
