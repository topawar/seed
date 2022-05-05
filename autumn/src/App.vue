<template>
  <div id="App">
    <keep-alive :include="['Register']">
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>
