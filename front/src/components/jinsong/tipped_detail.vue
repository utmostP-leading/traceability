<template>
  <a-layout id="components-layout-demo-fixed">
    <a-layout-header :style="{ position: 'fixed', zIndex: 1, width: '100%' }">
      <div class="logo" />
      <top-nav default_key = '[3]'></top-nav>
    </a-layout-header>

    <a-layout style="margin-top: 70px">
        <side-nav/>
        <a-layout-content :style="{ padding: '0 70px'}">
            <div :style="{ background: '#fff',  minHeight: '100px' }">
            <div style="fontWeight: 'bold'; padding-top: 20px">评论列表/详情</div>
                <a-divider></a-divider>
            </div>
            <div style="background: #fff ;fontWeight: 'bold'">
                <div style="margin-bottom: 10px">评论编号：{{$route.params.tipped_id}}</div>
                <div style="margin-bottom: 10px">
                <span style="margin-right: 200px">评论时间：</span><span>举报时间: </span>
                </div>
                <div style="margin-bottom: 10px">评论内容：{{tipped_msg.content}}</div>
                <div style="margin-bottom: 10px">举报原因：{{tipped_msg.tipReason}}</div>
                <a-divider></a-divider>
            </div>
            
            <div style="background: #fff">
                <a-button type='primary' @click="agree">同意</a-button>
                <a-button>否决</a-button>
            </div>
        </a-layout-content>
    </a-layout>
</a-layout> 
</template>
<script>
import sideNav from './side-nav.vue'
import topNav from './top-nav.vue';
import axios from 'axios';
export default {
    data:function(){
        return{
            tipped_ID: this.$route.params.tipped_id,
            tipped_msg: {
                CommentId: tipped_ID,
                content: '',
                tipReason: ''
            }
        }
    },
    methods:{
        agree:function(){

        }
    },
    components:{
        topNav,
        sideNav
    },
    created:function(){
        var it = this
        axios({
            method: 'get',
            url: 'tippedDetails/' + it.tipped_ID,
            
        }).then(res=>{
            console.log(res.statusCode)
            it.tipped_msg.CommentId = res.commentId,
            it.tipped_msg.content = res.content,
            it,tipped_msg.tipReason = res.tipReason
        })

    }
}
</script>
