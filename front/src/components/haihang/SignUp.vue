<template>
  <div style="height:100%;width:100%;background-color:#1ABC9C">
    <div style="width:100%; height:60px; background-color:black"></div>
    <div style="vertical-align: middle">
      <div
        class="components-input-demo-presuffix"
        style="text-align:center; margin-top:380px; margin-left:30px; margin-right:30px"
      >
        <a-input style="width:20%" placeholder="用户名" v-model="username"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input
          style="width:20% "
          placeholder="6-16位密码，区分大小写"
          v-model="password"
          ref="passwordInput"
        ></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input style="width:20% " placeholder="确认密码" v-model="password"></a-input>
      </div>
      <div style="margin-left:41%">
        <a-button type="primary" style="width:15%;" @click="signUp">注册</a-button>
        <router-link to="/signin">
          <a style="padding-left:5%">使用已有账户登录</a>
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
export default {
  data() {
    return {
      username: null,
      password: null
    };
  },
  methods: {
    signUp() {
      axios({
        method: "post",
        url: "/register",
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
      }).then(res => {});
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
