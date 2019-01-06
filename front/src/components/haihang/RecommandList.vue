<template>
  <div style="height:100%;width:100%;background-color:cyan">
    <a-menu v-model="current" mode="horizontal" theme="dark">
      <a-menu-item style="margin-left:20%; width:10%;text-align:center" key="home">
        <router-link to="/recommandlist">首页</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="list">
        <router-link to="/filelist">热点列表</router-link>
      </a-menu-item>
      <a-menu-item style="width:10%; text-align:center" key="detail">事件详情</a-menu-item>
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
            <a-menu-item key="9">推荐列表</a-menu-item>
            <a-menu-item key="10"></a-menu-item>
            <a-menu-item key="11"></a-menu-item>
            <a-menu-item key="12"></a-menu-item>
          </a-menu>
        </a-layout-sider>
        <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
          <a-card title="推荐事件">
            <a-card :title="item.eventTitle" v-for="item in event_card">
              <a slot="extra">
                <router-link to="/filedetail">详情</router-link>
              </a>
              {{item.eventIntro}}
            </a-card>
          </a-card>
        </a-layout-content>
      </a-layout>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      current: ["home"],
      event_card: ""
    };
  },

  mounted() {
    this.eventInit();
  },

  methods: {
    eventInit() {
      axios
        .get("recEvents")
        .then(res => {
          this.event_card = res.data.recEventList;
          console.log(this.event_card);
        })
        .catch(e => console.log(e));
      console.log("获取事件列表完毕");
    }
  }
};
</script>

  