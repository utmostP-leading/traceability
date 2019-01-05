<template>
  <div style="height:300%;width:100%;background-color:cyan">
    <a-menu v-model="current" mode="horizontal" theme="dark">
      <a-menu-item style="margin-left:20%; width:10%;text-align:center" key="mail">
        <router-link to="/signup">首页</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="app">
        <router-link to="/filelist">热点列表</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="alipay">事件详情</a-menu-item>
      <router-link to="/information">
        <a-avatar style="margin-left:35%" icon="user"/>
      </router-link>
    </a-menu>
    <div
      style="height:80%; margin-top:5%; margin-left:10%; margin-right:10%; background-color:white"
    >
      <a-layout style="padding: 24px 0; background: #fff">
        <a-layout-sider width="200" style="background: #fff">
          <a-timeline style="padding-left:30px;">
            <a-timeline-item>事件简介</a-timeline-item>
            <a-timeline-item>事件趋势</a-timeline-item>
            <a-timeline-item>事件信息流
              <p style="margin-top:25px;">起源期</p>
              <p>发展期</p>
              <p>高潮期</p>
              <p>完结</p>
            </a-timeline-item>
            <a-timeline-item>情感倾向</a-timeline-item>
            <a-timeline-item>事件评论</a-timeline-item>
          </a-timeline>
        </a-layout-sider>
        <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
          <a-card title="事件名">
            <a-card title="事件简介">Inner Card content</a-card>
            <a-card title="事件趋势" :style="{ marginTop: '16px' }">Inner Card content</a-card>
            <a-card title="事件信息流" :style="{ marginTop: '16px' }">
              <a-layout-sider width="150" style="background: #fff">
                <a-timeline style="padding-left:30px;">
                  <a-timeline-item>事件起源</a-timeline-item>
                  <a-timeline-item>事件发展</a-timeline-item>
                  <a-timeline-item>事件高潮</a-timeline-item>
                  <a-timeline-item>事件完结</a-timeline-item>
                </a-timeline>
              </a-layout-sider>
              <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
                <a-card>Inner Card content</a-card>
                <a-card :style="{ marginTop: '16px' }">Inner Card content</a-card>
                <a-card :style="{ marginTop: '16px' }">Inner Card content</a-card>
                <a-card :style="{ marginTop: '16px' }">Inner Card content</a-card>
              </a-layout-content>
            </a-card>
            <a-card title="情感倾向" :style="{ marginTop: '16px' }">Inner Card content</a-card>
            <a-card title="事件评论" :style="{ marginTop: '16px' }">
              <a-avatar style="margin-left:2%" icon="user"/>
              <a-input style="margin-left:5%; width:60%" placeholder="添加评论"/>
              <p ><a-avatar style="margin-left:2%; margin-top:5%" icon="user"/></p>
              UserName
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
      current: ["alipay"]
    };
  }
};
</script>
