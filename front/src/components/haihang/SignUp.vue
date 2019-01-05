<template>
  <div style="height:100%;width:100%;background-color:cyan">
    <div style="width:100%; height:60px; background-color:black"></div>
    <div style="vertical-align: middle">
      <div
        class="components-input-demo-presuffix"
        style="text-align:center; margin-top:400px; margin-left:30px; margin-right:30px"
      >
        <a-input style="width:20%" placeholder="手机号" v-model="phone" ref="phoneInput">
          <a-icon slot="prefix" type="phone"/>
          <a-icon v-if="phone" slot="suffix" type="close-circle" @click="emitEmpty"/>
        </a-input>
      </div>
      <div class="components-input-demo-presuffix" style="text-align:center; margin:30px">
        <a-input style="width:20% " placeholder="密码" v-model="password" ref="passwordInput">
          <a-icon slot="prefix" type="lock"/>
          <a-icon v-if="lock" slot="suffix" type="close-circle" @click="emitEmpty"/>
        </a-input>
      </div>
      <div style="margin-top:0px; margin-bottom:10px">
        <a href style="padding-left:56%">忘记密码</a>
      </div>
      <div style="text-align:center">
        <a-button type="primary" style="width:19%;">登录</a-button>
      </div>
      <div style="margin-top:20px;">
        <router-link to="/signin">
          <a style="padding-left:56%">注册账户</a>
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      phone: ""
    };
  },
  methods: {
    emitEmpty() {
      this.$refs.phoneInput.focus();
      this.phone = "";
      this.$refs.passwordInput.focus();
      this.password = "";
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
