<template>
  <div style="height:100%;width:100%;background-color:cyan">
    <div style="width:100%; height:60px; background-color:black"></div>
    <div style="vertical-align: middle">
      <div
        class="components-input-demo-presuffix"
        style="text-align:center; margin-top:400px; margin-left:30px; margin-right:30px"
      >
        <a-input style="width:20%" placeholder="用户名" v-model="username">
          <a-icon slot="prefix" type="phone"/>
          <a-icon v-if="phone" slot="suffix" type="close-circle"/>
        </a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input style="width:20% " placeholder="密码" v-model="password">
          <a-icon slot="prefix" type="lock"/>
          <a-icon v-if="lock" slot="suffix" type="close-circle"/>
        </a-input>
      </div>
      <div style="margin-top:0px; margin-bottom:10px">
        <a href style="padding-left:56%">忘记密码</a>
      </div>
      <div style="text-align:center">
        <a-button type="primary" style="width:19%;" @click="signIn">登录</a-button>
      </div>
      <div style="margin-top:20px;">
        <router-link to="/signup">
          <a style="padding-left:56%">注册账户</a>
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
import store from '../../store'
export default {
  data() {
    return {
      username: null,
      password: null,
      errcode: null
    };
  },
  methods: {
    signIn() {
      axios({
        method: "post",
        url: "/login",
        transformRequest: [
          function(data) {
            let newData = "";
            for (let k in data) {
              newData +=
                encodeURIComponent(k) + "=" + encodeURIComponent(data[k]) + "&";
            }
            return newData;
          }
        ],
        data: {
          username: this.username,
          password: this.password
        }
      }).then(res => {
        this.errcode =res.errCode;
        store.commit("setUserInfo",res.data);
      });
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
