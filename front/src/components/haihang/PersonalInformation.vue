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
      style="height:70%; margin-top:10%; margin-left:10%; margin-right:10%; background-color:white"
    >
      <div style="padding-top:5%; margin-left:58%">
        <a-avatar :size="70" icon="user"/>
      </div>
      <div
        class="components-input-demo-presuffix"
        style="padding-left:30%;  padding-top:50px; margin-left:30px; margin-right:30px"
      >个人账号：
        <a-input style="width:20%" placeholder="账号" v-model="email" ref="emailInput"></a-input>
        <a-button style="margin-left:120px; width:10%;">上传头像</a-button>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">个人昵称：
        <a-input style="width:20% " placeholder="昵称" v-model="password" ref="passwordInput"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:32%; margin:30px">生日：
        <a-input style="width:20% " placeholder="年-月-日" v-model="password" ref="passwordInput"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">联系方式：
        <a-input style="width:20% " placeholder="11位手机号" v-model="phone" ref="phoneInput"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="padding-left:30%; margin:30px">个人简介：
        <a-textarea placeholder="Basic usage" :rows="4" style="width:45%"/>
      </div>
      <div style="text-align:center">
        <a-button type="primary" style="width:10%;">提交</a-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: ["user"]
    };
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

