<template>
    <p>RawMaterial</p>
    <RawMaterialsListView/>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue';
import RawMaterialsListView from '../components/RawMaterialsListView.Vue';

</script>

<style scope>
.list{
  float: left;
}
</style>
