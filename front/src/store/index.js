import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    //声明全局变量，通过this.$store.state访问
    state: {
        userInfo:null,
        eventId:null
    },
    //在getters中声明state中变量的计算函数，缓存计算后的数据，通过this.$store.getters调用
    getters: {
        isLogin(state){
            if(state.userInfo==null){
                return false;
            }else{
                return true;
            }
        }
    },
    //执行同步方法，改变state状态，通过this.$store.commit调用
    mutations: {
        setUserInfo(state,userInfo){
            state.userInfo=userInfo
        },
        setEventId(state,eventId){
            state.eventId=eventId
        }
    },
    //以异步方式执行mutations，通过this.$store.dispatch调用
    actions: {

    }
})