<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <nav>
        <RouterLink to="/foodManager">Home</RouterLink>
        <RouterLink to="/foodAdd">add</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>
