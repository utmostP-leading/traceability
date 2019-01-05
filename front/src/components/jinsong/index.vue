<template>
  <a-layout id="components-layout-demo-fixed">
    <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
      <div class="logo" />
      <top-nav default_key = '[1]'></top-nav>
    </a-layout-header>

    <a-layout-content :style="{ padding: '0 50px', marginTop: '64px' }">
      <a-breadcrumb :style="{ margin: '26px 0' }">
        <a-breadcrumb-item >事件管理/</a-breadcrumb-item>
        <a-breadcrumb-item >事件列表</a-breadcrumb-item>
      </a-breadcrumb>
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件列表</div>
          <div class="event">
              <Event></Event>
          </div>
      </div>
    </a-layout-content>
    <a-layout-footer :style="{ textAlign: 'center' }">
      
    </a-layout-footer>
  </a-layout>
</template>
<script>

import topNav from './top-nav.vue';
import Event from './eventcard.vue';
import axios from 'axios'
export default {
  data () {
    return {
      
    }
  },
  methods:{
    
  },
  components:{
      topNav,
      Event
  },
  created:function(){
    // axios({
    //   method: 'get',
    //   url: '',
    // }).then(res=>{
      
    // })
  }
}
</script>

<style>
#components-layout-demo-fixed .logo  {
  width: 120px;
  height: 31px;

  margin: 16px 28px 16px 0;
  float: left;
}
</style>

