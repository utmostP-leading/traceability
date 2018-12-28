import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
//import store from './store'
import axios from 'axios'
import routes from './router'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'


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
  // if (!store.state.isLogin) {
  //   if (to.path === '/login') {
  //     next()
  //   } else {
  //     next('/login')
  //   }
  // }
  next();
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
