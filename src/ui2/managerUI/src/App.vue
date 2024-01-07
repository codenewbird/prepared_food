<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <nav>
        <RouterLink to="/foodManager">Home</RouterLink>&nbsp;&nbsp;
        <RouterLink to="/foodAdd">foodAdd</RouterLink>&nbsp;&nbsp;
        <RouterLink to="/lineAdd">lineAdd</RouterLink>&nbsp;&nbsp;
        <RouterLink to="/lineManager">lineManager</RouterLink>&nbsp;&nbsp;
        <RouterLink to="/lotAdd">lotAdd</RouterLink>
        <RouterLink to="/commentRuleSet">用户反馈监测规则设定</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>
