<template>
  <a-layout id="components-layout-demo-fixed">  
    <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
      <div class="logo" />
      <top-nav default_key = '[3]'></top-nav>
    </a-layout-header>

    <a-layout style="margin-top: 70px">
        <side-nav></side-nav>
        <router-view></router-view>
    </a-layout>
  </a-layout>
</template>
<script>
import topNav from './top-nav.vue';
import sideNav from './side-nav.vue'


export default {
  data () {
    return {

    }
  },
  components:{
      topNav,
      sideNav
  },
  methods: {

  },
  created: function(){
    this.$router.push('/tipped/unexamined')
  }
}
</script>

<style>

</style>
