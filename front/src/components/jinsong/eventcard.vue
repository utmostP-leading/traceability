<template>
  <div style="background-color: #ececec; padding: 20px;">
    <a-row :gutter="16" >
      <a-col :span="8">
        <a-card title="事件" :bordered="true" style="width: 300px; min-height: 200px">
          <p></p>
          <div>
            <router-link to = '/addEvent'>
            <a-button style="width:100%" type="primary" :size = 'large'>新增</a-button>
            </router-link>
          </div>
        </a-card>
      </a-col>

      <a-col :span="8" v-for="item in event_card">
        <a-card :title="item.eventTitle" :bordered="true" style="width: 300px ;min-height: 200px">
          <p>{{item.eventIntro}}</p>
          <div>
            <a-button-group style="bottom: 0; width: 100%">
              <router-link :to = "'/modifyEvent/' + item.eventId">
              <a-button style="width:50%" type="primary" :size = 'large' >修改</a-button>
              </router-link>
              
              <a-button style="width:50%" type="danger" :size = 'large' @click="delete_card(item.eventId)">删除</a-button>
           
            </a-button-group>
          </div>
        </a-card>
      </a-col>      
    </a-row>    
  </div>
</template>

<script>

import axios from 'axios'
const datasource = [
  {
    eventId: 1,
    eventTitle: 'agesdgsd',
    eventIntro: 'sdgn来拿过来win哈；了；弄isdgn'
  },
  
  {
    eventId: 3,
    eventTitle: 'agesdgsd',
    eventIntro: 'sdgnis给宏伟化工围湖工；啊dgn'
  },
  {
    eventId: 4,
    eventTitle: 'agesdgsd',
    eventIntro: 'sdgnis是东莞哪里；还捏了牛逼了；而我；违规dgn'
  },
  {
    eventId: 5,
    eventTitle: 'agesdgsd',
    eventIntro: 'sd废话工委会工位；哼；哦为何你玩gn'
  },
  {
    eventId: 6,
    eventTitle: 'agesdgsd',
    eventIntro: 'sdgnisdgnsdfsssssssss阿吉豆咯好狗爱围观偶还弄完了哦忘了ssssssss'
  },
]

export default {
  data: function(){
    return{
      event_card: datasource
    }
  },
  created:function(){
    var it = this
    axios({
      method: 'get',
      url: '/events',
    }).then(res=>{
      console.log(res.statusCode)
      it.event_card = res.data.eventList
    })
  },
  methods:{
    delete_card: function(e){
      var it = this
      this.$confirm({
        title: '确认要删除该事件吗？',
        content: '删除后不可恢复！',
        okText: '确认',
        okType: 'danger',
        cancelText: '取消',
        onOk(){
          axios({
        method: 'delete',
        url: '/event/' + e,       
          })
          it.event_card.forEach(element => {
            if (element.eventId == e){
              var index = it.event_card.indexOf(element)
              it.event_card.splice(index,1)
            }
          });
        },
        onCancel(){

        }
      })
    },
  },
 
}
</script>
