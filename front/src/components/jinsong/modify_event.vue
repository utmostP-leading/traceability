<template>
    <a-layout id="components-layout-demo-fixed">
    <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
      <div class="logo" />
      <top-nav default_key = '[2]'></top-nav>
    </a-layout-header>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '100px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '100px' }">
          <div style="fontWeight: 'bold'">修改事件</div>
          <div>
              <a-input type="text" placeholder="事件名称" v-model="eventTitle" />
          </div>
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件简介</div>
          <div class="introduction">
              <a-textarea :autosize= "{minRows: 10,maxRows:10}" v-model="eventIntro"/>
          </div>
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件趋势</div>
          <div class="trend" v-for="item in eventNodeList" >
              <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                    <a-col :span= "4">事件节点ID</a-col>
                    <a-col :span="4">事件节点名称</a-col>
                    <a-col :span="4">时间</a-col>
                    <a-col :span='4'>积极情感热度</a-col>
                    <a-col :span='4'>中立情感热度</a-col>
                    <a-col :span='4'>消极情感热度</a-col>
                    
              </a-row>

              
              <a-row :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='4'><a-input v-model="item.eventNodeId"/></a-col>
                    <a-col :span='4'><a-input v-model="item.eventNodeTitle"/></a-col>
                    <a-col :span='4'><a-input v-model="item.eventNodeTime" placeholder="格式如2000-01-01"/></a-col>
                    <a-col :span='4'><a-input v-model="item.positiveFever"/></a-col>
                    <a-col :span='4'><a-input v-model="item.neutralFever"/></a-col>
                    <a-col :span='4'><a-input v-model="item.negativeFever"/></a-col>
                    
              </a-row> 
              <div>描述</div>
              <div>
                  <a-textarea :autosize= "{minRows: 10,maxRows:10}" v-model="item.eventNodeDescription"></a-textarea>
              </div>
              <a-divider></a-divider>
          </div> 


          <div>
                  <button @click="add_input">新建</button>
                  <button @click="delete_input">删除</button>
                  
          </div>
          
      </div>
        
    </a-layout-content>

    <!-- <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件信息流</div>
          <div class="event_stream">
              <Event></Event>
          </div>
      </div>
    </a-layout-content> -->

    <!-- <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">情感倾向</div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">
            <div style="display:inline">积极情感</div>
          </div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              
              <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                        <a-col :span="12">事件节点名称</a-col>
                        <a-col :span='12'>热度</a-col>
              </a-row>
              <a-row  v-for="item in eventNodeList" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.eventNodeTitle"/></a-col>
                    
                    <a-col :span='12'><a-input v-model="item.positiveFever"/></a-col>
              </a-row> 
              
          </div>

          <a-divider></a-divider>

          

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">
            <div style="display:inline">消极情感</div>
          </div>
          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                        <a-col :span="12">事件节点名称</a-col>
                        <a-col :span='12'>热度</a-col>
              </a-row>
              <a-row  v-for="item in eventNodeList" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.eventNodeTitle"/></a-col>
                    <a-col :span='12'><a-input v-model="item.negativeFever"/></a-col>
              </a-row> 
              
          </div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">
            <div style="display:inline">中立情感</div>
          </div>
          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                        <a-col :span="12">事件节点名称</a-col>
                        <a-col :span='12'>热度</a-col>
              </a-row>
              <a-row  v-for="item in eventNodeList" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.eventNodeTitle"/></a-col>
                    <a-col :span='12'><a-input v-model="item.neutralFever"/></a-col>
              </a-row> 
              
          </div>
      </div>
    </a-layout-content> -->

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <a-button type='primary' @click="Submit">提交</a-button>
    </a-layout-content>

    
    <a-layout-footer :style="{ textAlign: 'center' }">
      
    </a-layout-footer>
  </a-layout>
</template>


<script>
import topNav from './top-nav.vue';
import Event from './eventcard.vue';
import axios from 'axios'
export default {
    data:function(){
        return {
            eventId: this.$route.params.eventId,
            eventTitle: '',
            eventIntro: '',
            eventNodeList: []


            // eventTitle : 'biaoti',
            // eventIntro : 'jieshao',
            // eventNodeList : [{
            //     eventId: this.$route.params.eventId,
            //     eventNodeId: '',
            //     eventNodeTitle: 'nodetitle',
            //     eventNodeFever: '30',
            //     eventNodeDescription: 'sdggweg',
            //     eventNodeTime: '2018-12-10',
            //     positiveFever: '10',
            //     neutralFever: '10',
            //     negativeFever: '10'
            // }]
        }
    },
    components:{
        topNav,
        Event
    },
    methods:{
        add_input:function(){
            this.eventNodeList.push({
                eventId: this.$route.params.eventId,
                eventNodeId: '',
                eventNodeTitle: '',
                eventNodeDescription: '',
                eventNodeTime: '',
                positiveFever: '',
                neutralFever: '',
                negativeFever: '',
                eventNodeFever: 0,
            })
        },
        delete_input: function(){
            this.eventNodeList.pop()
        },

        Submit:function(){
            this.eventNodeList.forEach(item=>{
                item.eventNodeFever = parseInt(item.positiveFever) + parseInt(item.neutralFever) + parseInt(item.negativeFever)
            })

            var it = this
            axios({
                method: 'put',
                url: '/event',
                header:{
                    "Content-Type": 'application/json'
                },
                data: {
                    eventId: it.eventId,
                    eventTitle: it.eventTitle,
                    eventIntro: it.eventIntro,
                    eventNodeList: it.eventNodeList
                }
            }).then(res=>{
                console.log(res)
            })
        }
    },
    
    created: function(){
        var it = this
        
        axios({
            method: 'get',
            url: '/eventDetails/' + this.$route.params.eventId
        }).then(res=>{
            it.eventTitle = res.data.event.eventTitle
            it.eventId = res.data.event.eventId
            it.eventIntro = res.data.event.eventIntro
            it.eventNodeList = res.data.eventNodeList
        })
        
    }
}
</script>

<style>

</style>


