import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import routes from './router'

import Antd from 'ant-design-vue'
import "ant-design-vue/dist/antd.css";

import axios from 'axios'
import store from './store'

Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(Antd)
axios.defaults.baseURL="/api"

const router=new VueRouter({
  routes
})

//路由守卫
router.beforeEach(function (to, from, next) {
  //未登录，跳转到登录页
  if (!store.getters.isLogin) {
    if (to.path==='/signin'||to.path==='/signup') {
      next();
    } else {
      next('/signin');
    }
  }
  next();
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
