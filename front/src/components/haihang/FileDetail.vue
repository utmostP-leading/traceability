<template>
  <div style="height:300%;width:100%;background-color:cyan">
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
          <a-card :title="event.eventTitle">
            <a-card title="事件简介">{{event.eventIntro}}</a-card>
            <a-card title="事件趋势" :style="{ marginTop: '16px' }">
              <div id="myChart"></div>
            </a-card>
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
                <a-card>{{start}}</a-card>
                <a-card :style="{ marginTop: '16px' }">{{develop}}</a-card>
                <a-card :style="{ marginTop: '16px' }">{{hightide}}</a-card>
                <a-card :style="{ marginTop: '16px' }">{{end}}</a-card>
              </a-layout-content>
            </a-card>
            <a-card title="情感倾向" :style="{ marginTop: '16px' }">Inner Card content</a-card>
            <a-card title="事件评论" :style="{ marginTop: '16px' }">
              <a-avatar style="margin-left:2%" icon="user"/>
              <a-input style="margin-left:5%; width:60%" v-model="commitReview" placeholder="添加评论"/>
              <a-button type="primary" style="margin-left:15%; width:7%;" @click="commit">提交</a-button>
              <a-card :style="{ marginTop: '16px' }">
                <a-card-grid style="width:10%;textAlign:'center'">
                  <a-avatar style="margin-left:2%; margin-top:2%" icon="user"/>
                </a-card-grid>
                {{comment.commentContent}}
              </a-card>
            </a-card>
          </a-card>
        </a-layout-content>
      </a-layout>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import echarts from "echarts";
export default {
  data() {
    return {
      current: ["detail"],
      intro: event.eventIntro,
      trend: "",
      develop: "",
      hightide: "",
      end: "",
      review: "",
      event:null,
      comment:null,
      eventTrend:null
    };
  },
  mounted() {
    this.detailInit();
    console.log("event:",this.event)
    //  this.drawTable();
  },

  methods: {
    detailInit() {
      var that =this;
      axios
        .get("/eventDetails/1")
        .then(res => {
          that.comment = res.data.commentList;
          that.event = res.data.event;
          that.eventTrend = res.data.eventNodeList;
          console.log(res.data.event)
        })
        .catch(e => console.log(e));
      console.log("获取个人信息完毕");
    },
    commit() {
      axios({
        method: "post",
        url: "/comments",
        data: {
          userId: 1,
          eventId: 1,
          content: "this.commitreview"
        }
      });
    },

    // userGet() {
    //   axios
    //     .get("/login")
    //     .then(res => {
    //       (this.userName= res.data.username)
    //     })
    //     .catch(e => console.log(e));
    // },

    // eventGet() {
    //   axios
    //     .get("/subEvents/1")
    //     .then(res => {
    //       (this.eventID= res.data.eventId)
    //     })
    //     .catch(e => console.log(e));
    // },

    // drawTable() {
    //   let myChart = echarts.init(document.getElementById("myChart"));
    //   myChart.setOption({
    //     title: {},
    //     tooltip: {},
    //     xAxis: {
    //       data: [event.eventNodeTime]
    //     },
    //     yAxis: {
    //       data: [100, 200, 300, 400]
    //     },
    //     series: [
    //       {
    //         name: "热度",
    //         type: "line",
    //         data: [event.eventNodeFever]
    //       }
    //     ]
    //   });
    // }
  }
};
</script>
