<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <nav>
        <RouterLink to="/foodManager">Home</RouterLink>
        <RouterLink to="/foodAdd">foodAdd</RouterLink>
        <RouterLink to="/lineAdd">lineAdd</RouterLink>
        <RouterLink to="/lineManager">lineManager</RouterLink>
        <RouterLink to="/lotAdd">lotAdd</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>
