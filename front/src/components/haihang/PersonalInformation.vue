<template>
  <div style="height:100%;width:100%;background-color:#1ABC9C">
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
      style="height:70%; margin-top:10%; margin-left:10%; margin-right:10%; background-color:white"
    >
      <div style="padding-top:5%; margin-left:58%">
        <a-avatar :size="70" icon="user"/>
      </div>
      <div
        class="components-input-demo-presuffix"
        style="padding-left:30%;  padding-top:50px; margin-left:30px; margin-right:30px"
      >个人账号：
        <a-input style="width:20%" placeholder="账号" v-model="ID"></a-input>
        <a-button style="margin-left:120px; width:10%;">上传头像</a-button>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">个人昵称：
        <a-input style="width:20% " placeholder="昵称" v-model="nickname"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:32%; margin:30px">性别：
        <a-input style="width:20% " placeholder="性别" v-model="sex"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">联系方式：
        <a-input style="width:20% " placeholder="11位手机号" v-model="phone"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">个人简介：
        <a-textarea v-model="intro" placeholder="Basic usage" :rows="4" style="width:45%"/>
      </div>
      <div style="text-align:center">
        <a-button type="primary" style="width:10%;" @click="submitInfor">提交</a-button>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import store from "../../store";
export default {
  data() {
    return {
      current: ["user"],
      ID: "",
      nickname: "",
      sex: "",
      phone: "",
      intro: ""
    };
  },

  mounted() {
    this.informationInit();
  },

  methods: {
    informationInit() {
      axios
        .get("profiles/"+store.state.userInfo.data.userId)
        .then(res => {
          (this.nickname = res.data.userProfile.username),
            (this.phone = res.data.userProfile.tel),
            (this.intro = res.data.userProfile.intro),
            (this.sex = res.data.userProfile.sex);
        })
        .catch(e => console.log(e));
      console.log("获取个人信息完毕");
    },

    submitInfor() {
      axios({
        method: "put",
        url: "/profiles",
        data: {
          userId:store.state.userInfo.data.userId,
          userSex: this.sex,
          userImg:"",
          userTel: this.phone,
          userIntro: this.intro
        }
      })
        .then(res => {
          console.log(res.data);
        })
        .catch(e => console.log(e));
    }
  }
};
</script>

<style scoped>
.components-input-demo-presuffix .anticon-close-circle {
  cursor: pointer;
  color: #ccc;
  transition: color 0.3s;
  font-size: 12px;
}
.components-input-demo-presuffix .anticon-close-circle:hover {
  color: #999;
}
.components-input-demo-presuffix .anticon-close-circle:active {
  color: #666;
}
</style>

