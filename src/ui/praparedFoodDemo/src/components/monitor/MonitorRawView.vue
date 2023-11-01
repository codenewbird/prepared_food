<template>
    <div class="left">
        
    </div>
    <div class="right">
        <p class="title">原料储存仓库</p>
        <MonitorDataView/>
    </div>
</template>

<script setup>
    import MonitorDataView from '@/components/monitor/MonitorDataView.vue'
</script>

<style scoped>
    .left{
        float: left;
        width: 80%;
        height: 600px;
        border: 1px solid;
    }
    .right{
        float: left;
        width: 19%;
    }
    .title{
        color:#F00;
    }
</style>