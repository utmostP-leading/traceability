<template>
    <a-layout id="components-layout-demo-fixed">
    <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
      <div class="logo" />
      <top-nav default_key = '[2]'></top-nav>
    </a-layout-header>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '100px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '100px' }">
          <div style="fontWeight: 'bold'">添加/修改事件</div>
          <div>
              <a-input type="text" placeholder="事件名称" v-model="event_name" />
          </div>
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件简介</div>
          <div class="introduction">
              <a-textarea :autosize= "{minRows: 10,maxRows:10}" v-model="event_intro"/>
          </div>
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件趋势</div>
          <div class="trend">
              <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                    <a-col :span="8">时间</a-col>
                    <a-col :span='8'>热度</a-col>
                    <a-col :span='8'>描述</a-col>
              </a-row>
              
              <a-row  v-for="item in trend_dataset" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='8'><a-input v-model="item.time"/></a-col>
                    <a-col :span='8'><a-input v-model="item.hot"/></a-col>
                    <a-col :span='8'><a-input v-model="item.desc"/></a-col>
              </a-row> 
          </div> 
          <div>
                  <button @click="add_input">新建</button>
                  <button @click="delete_input">删除</button>
                  
          </div>
          
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">事件信息流</div>
          <div class="event_stream">
              <Event></Event>
          </div>
      </div>
    </a-layout-content>

    <a-layout-content :style="{ padding: '0 170px', marginTop: '32px' }">
      <div :style="{ background: '#fff', padding: '24px', minHeight: '380px' }">
          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">情感倾向</div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '20px'}">
            <a-row :gutter="16" style="border: 2px;margin-bottom: 10px " >
                        <a-col :span="12">时间</a-col>
                        <a-col :span='12'>热度</a-col>
            </a-row>
          </div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              <div style="display:inline">积极情感</div>
              <a-row  v-for="item in active_emotion" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.time"/></a-col>
                    <a-col :span='12'><a-input v-model="item.hot"/></a-col>
              </a-row> 
              <div>
                  <button @click="add_active_input">新建</button>
                  <button @click="delete_active_input">删除</button>
              </div>
          </div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              <div style="display:inline">消极情感</div>
              <a-row  v-for="item in passive_emotion" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.time"/></a-col>
                    <a-col :span='12'><a-input v-model="item.hot"/></a-col>
              </a-row> 
              <div>
                  <button @click="add_passive_input">新建</button>
                  <button @click="delete_passive_input">删除</button>
              </div>
          </div>

          <a-divider></a-divider>

          <div :style="{margin: '15px 0', fontWeight: 'bold', fontSize: '15px'}">
              <div style="display:inline">中立情感</div>
              <a-row  v-for="item in netural_emotion" :gutter='16' style="border: 2px; margin-bottom: 10px ">
                    <a-col :span='12'><a-input v-model="item.time"/></a-col>
                    <a-col :span='12'><a-input v-model="item.hot"/></a-col>
              </a-row> 
              <div>
                  <button @click="add_netural_input">新建</button>
                  <button @click="delete_netural_input">删除</button>
              </div>
          </div>
      </div>
    </a-layout-content>

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
            event_name: '',
            event_intro: '',
            trend_dataset:[
                {time:'', hot:'', desc:''},
                {time:'', hot:'', desc:''},
                {time:'', hot:'', desc:''},
                {time:'', hot:'', desc:''},
            ],
            active_emotion: [
                {time: '', hot: ''},
                {time: '', hot: ''},
                {time: '', hot: ''}
            ],
            passive_emotion: [
                {time: '', hot: ''},
                {time: '', hot: ''},
                {time: '', hot: ''}
            ],
            netural_emotion: [
                {time: '', hot: ''},
                {time: '', hot: ''},
                {time: '', hot: ''}
            ]

        }
    },
    components:{
        topNav,
        Event
    },
    methods:{
        add_input:function(){
            this.trend_dataset.push({time:'', hot:'', desc:''})
        },
        delete_input: function(){
            this.trend_dataset.pop()
        },
        add_active_input: function(){
            this.active_emotion.push({time:'', hot:''})
        },
        delete_active_input: function(){
            this.active_emotion.pop()
        },
        add_passive_input: function(){
            this.passive_emotion.push({time:'', hot:''})
        },
        delete_passive_input: function(){
            this.passive_emotion.pop()
        },
        add_netural_input: function(){
            this.netural_emotion.push({time:'', hot:''})
        },
        delete_netural_input: function(){
            this.netural_emotion.pop()
        },

        Submit:function(){
            var it = this
            axios({
                method: 'post',
                url: '',
                data: {
                    event_name: it.event_name,
                    event_intro: it.event_intro,
                    trend_dataset: it.trend_dataset,
                    active_emotion: it.active_emotion,
                    passive_emotion: it.passive_emotion,
                    netural_emotion: it.netural_emotion

                }
            })
        }
    }
}
</script>

<style>

</style>


