<template>
<div>
    <a-menu
        theme="dark"
        mode="horizontal"
        :defaultSelectedKeys= "default_key"
        :style="{ lineHeight: '64px' }"
      >
      
      <a-menu-item key="1"><router-link to='/index'>首页</router-link></a-menu-item>
      
      
      <a-menu-item key="2"><router-link to = '/addEvent'>事件管理</router-link></a-menu-item>
      
      <a-menu-item key="3"><router-link to = '/tipped/unexamined'>举报管理</router-link></a-menu-item>
    </a-menu>
</div>
</template>

<script>

export default {
  data () {
    return {
      
    }
  },
  props:['default_key']
}
</script>


