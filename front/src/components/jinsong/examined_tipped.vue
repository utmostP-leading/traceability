<template>
    <a-layout-content :style="{ padding: '0 70px'}">
          <div :style="{ background: '#fff',  minHeight: '100px' }">
            <div style="fontWeight: 'bold'; padding-top: 20px">{{sign}}/评论列表</div>
            <a-divider></a-divider>
          <div>
               <table >
                 <tr style="margin-bottom: 30px">
                   <td >序号</td>
                   <a-divider type="vertical" />
                   <td >已审核评论</td>
                   <a-divider type="vertical" />
                   <td >已审核的用户</td>
                   <a-divider type="vertical" />
                   <!-- <td >举报人</td>
                   <a-divider type="vertical" /> -->
                   <td >评论时间</td>
                   <!-- <a-divider type="vertical" />
                   <td >操作</td> -->
                 </tr>
                 <tr v-for="item in checkedTipped_comment" style="margin-bottom: 15px">
                  
                   <td><router-link :to="'/detail/' + item.commentId">{{item.commentId}}</router-link></td>

                   <a-divider type="vertical" />
                   <td>{{item.commentContent}}</td>
                   <a-divider type="vertical" />
                   <td>{{item.userId}}</td>
                   <a-divider type="vertical" />
                   <!-- <td>{{item.tip_user}}</td>
                   <a-divider type="vertical" /> -->
                   <td>{{item.commentTime}}</td>
                   <a-divider type="vertical" />
                   <!-- <td>
                     <button @click="pass(item.commentId)">同意</button>
                     <button @click="reject(item.commentId)">否决</button>
                   </td> -->
                 </tr>
               </table>
            </div>
          </div>
        </a-layout-content>
</template>
<script>
import axios from 'axios'
const datasource = [{
  key: '1',
  ID: '001',
  tipped_content: 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaasdddddddddddd',
  tipped_user: 'Jokie',
  tip_user: 'Jokey',
  tip_time: '2018-10-1',
},{
  key: '2',
  ID: '002',
  tipped_content: 'aaaaaaaaaaaaaaaaaaaaaaaaaaddddddddddd',
  tipped_user: 'Jokey',
  tip_user: 'Jokie',
  tip_time: '2018-10-2',
}]
export default {
    data:function(){
        return{
            checkedTipped_comment: [],
            
            sign: '已审核举报'
        }
    },
    created:function(){
      var it = this
      axios({
        method: 'get',
        url: '/checkTippedList',

      }).then(res=>{
        console.log(res.data.statusCode)
        it.checkedTipped_comment = res.data.checkedTipped_comment
        
      })
    },
    methods: {
      // pass: function(e) {
      //   axios({
      //     method: 'patch',
      //     url: '/tippedComments',
      //     data: {
      //       commentId: e
      //     }
      //   })
      // },
      // reject: function(e){
      //   axios({
      //     method: 'patch',
      //     url: '/nonTippedComments',
      //     data: {
      //       commentId: e
      //     }
      //   })
      // }
    }
}
</script>

<style>
td{
  min-width:150px;
}
</style>


