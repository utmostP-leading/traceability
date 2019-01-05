<template>
  <div style="height:100%;width:100%;background-color:cyan">
    <div style="width:100%; height:60px; background-color:black"></div>
    <div style="vertical-align: middle">
      <div
        class="components-input-demo-presuffix"
        style="text-align:center; margin-top:380px; margin-left:30px; margin-right:30px"
      >
        <a-input style="width:20%" placeholder="邮箱" v-model="email" ref="emailInput"></a-input>
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
        <a-input style="width:20% " placeholder="确认密码" v-model="password" ref="passwordInput"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input style="width:20% " placeholder="11位手机号" v-model="phone" ref="phoneInput"></a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input
          style="width:10% ; margin-right:35px"
          placeholder="输入验证码"
          v-model="password"
          ref="passwordInput"
        ></a-input>
        <a-button style="width:8%;">获取验证码</a-button>
      </div>
      <div style="margin-left:41%">
        <a-button type="primary" style="width:15%;">注册</a-button>
        <router-link to="/signup">
          <a style="padding-left:5%">使用已有账户登录</a>
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      email: ""
    };
  },
  methods: {
    emitEmpty() {
      this.$refs.emailInput.focus();
      this.email = "";
      this.$refs.passwordInput.focus();
      this.password = "";
      this.$refs.phoneInput.focus();
      this.phone = "";
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
