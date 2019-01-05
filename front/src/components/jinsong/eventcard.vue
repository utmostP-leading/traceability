<template>
  <div style="background-color: #ececec; padding: 20px;">
    <a-row :gutter="16" >
      <a-col :span="8">
        <a-card title="事件" :bordered="true" style="width: 300px; height: 173px">
          <p></p>
          <div>
            <router-link to = '/add'>
            <a-button style="width:100%" type="primary" :size = 'large'>新增</a-button>
            </router-link>
          </div>
        </a-card>
      </a-col>

      <a-col :span="8" v-for="item in event_card">
        <a-card :title="item.event_name" :bordered="true" style="width: 300px">
          <p>{{item.event_discribe}}</p>
          <div>
            <a-button-group style="bottom: 0; width: 100%">
              <router-link to = '/add'>
              <a-button style="width:50%" type="primary" :size = 'large'>修改</a-button>
              </router-link>
              <a-button style="width:50%" type="danger" :size = 'large' @click="delete_card(item.event_id)">删除</a-button>
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
    event_id: 1,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
  },
  {
    event_id:2,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
  },
  {
    event_id:3,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
  },
  {
    event_id:4,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
  },
  {
    event_id:5,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
  },
  {
    event_id:6,
    event_name: 'agesdgsd',
    event_discribe: 'sdgnisdgn'
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
    // axios({
    //   method: 'get',
    //   url: '',
    // }).then(res=>{
    //   it.event_card = res
    // })
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
      // axios({
      //   method: 'delete',
      //   url: '',
      //   data: {
      //     delete_ID: e
      //   }
      // })
    }
  },
 
}
</script>
