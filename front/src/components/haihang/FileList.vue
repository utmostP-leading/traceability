<template>
  <div style="height:100%;width:100%;background-color:cyan">
    <a-menu v-model="current" mode="horizontal" theme="dark">
      <a-menu-item style="margin-left:20%; width:10%;text-align:center" key="mail">
        <router-link to="/signup">首页</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="app">
        <router-link to="/filelist">热点列表</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="alipay">
      事件详情
      </a-menu-item>
      <router-link to="/information">
        <a-avatar style="margin-left:35%" icon="user"/>
      </router-link>
    </a-menu>
    <div
      style="height:80%; margin-top:5%; margin-left:10%; margin-right:10%; background-color:white"
    >
      <a-layout style="padding: 24px 0; background: #fff">
        <a-layout-sider width="200" style="background: #fff">
          <a-menu mode="inline" style="height: 100%; text-align:center ">
            <a-menu-item key="9">热点列表</a-menu-item>
            <a-menu-item key="10"></a-menu-item>
            <a-menu-item key="11"></a-menu-item>
            <a-menu-item key="12"></a-menu-item>
          </a-menu>
        </a-layout-sider>
        <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
          <a-card title="热点">
            <p
              style="fontSize: 14px;color: rgba(0, 0, 0, 0.85); marginBottom: 16px;fontWeight: 500"
            >Group title</p>
            <a-card title="Inner card title">
              <a  slot="extra"><router-link to="/filedetail">详情</router-link></a>
              Inner Card content
            </a-card>
            <a-card title="Inner card title" :style="{ marginTop: '16px' }">
              <a  slot="extra"><router-link to="/filedetail">详情</router-link></a>
              Inner Card content
            </a-card>
          </a-card>
        </a-layout-content>
      </a-layout>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: ["9"]
    };
  }
};
</script>

  