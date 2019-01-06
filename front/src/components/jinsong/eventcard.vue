<template>
  <div style="background-color: #ececec; padding: 20px;">
    <a-row :gutter="16" >
      <a-col :span="8">
        <a-card title="事件" :bordered="true" style="width: 300px; height: 173px">
          <p></p>
          <div>
            <router-link to = '/addEvent'>
            <a-button style="width:100%" type="primary" :size = 'large'>新增</a-button>
            </router-link>
          </div>
        </a-card>
      </a-col>

      <a-col :span="8" v-for="item in event_card">
        <a-card :title="item.eventTitle" :bordered="true" style="width: 300px">
          <p>{{item.eventDescription}}</p>
          <div>
            <a-button-group style="bottom: 0; width: 100%">
              <router-link to = '/addEvent'>
              <a-button style="width:50%" type="primary" :size = 'large'>修改</a-button>
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
    eventDescription: 'sdgnisdgn'
  },
  {
    eventId: 2,
    eventTitle: 'agesdgsd',
    eventDescription: 'sdgnisdgn'
  },
  {
    eventId: 3,
    eventTitle: 'agesdgsd',
    eventDescription: 'sdgnisdgn'
  },
  {
    eventId: 4,
    eventTitle: 'agesdgsd',
    eventDescription: 'sdgnisdgn'
  },
  {
    eventId: 5,
    eventTitle: 'agesdgsd',
    eventDescription: 'sdgnisdgn'
  },
  {
    eventId: 6,
    eventTitle: 'agesdgsd',
    eventDescription: 'sdgnisdgn'
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
      url: 'events',
    }).then(res=>{
      it.event_card = res
    })
  },
  methods:{
    delete_card: function(e){
      // var it = this
      // this.event_card.forEach(function(item){
      //   if(item.event_id == e){
      //     var index = it.event_card.indexOf(item)
      //     it.event_card.splice(index, 1)
      //   }
      // })
      axios({
        method: 'delete',
        url: 'event/' + e,
        
      })
    }
  },
 
}
</script>
