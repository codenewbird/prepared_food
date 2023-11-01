<template>
    <div> 
        <span @click="open('dish')">原料储存仓库</span>
        <span>|</span>
        <span @click="open('')">菜品制作地拍摄</span>   
        <span>|</span>
        <span @click="open('')">运输冷链摄制</span>  
    </div>
    <RouterView/>
</template>

<script setup>
    import { RouterView,useRouter } from 'vue-router'
    let router = useRouter();
    const open = function(name){
    router.push({name: name})
};
</script>

<style>

</style>