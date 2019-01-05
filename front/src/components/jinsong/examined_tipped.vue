<template>
    <a-layout-content :style="{ padding: '0 70px'}">
          <div :style="{ background: '#fff',  minHeight: '100px' }">
            <div style="fontWeight: 'bold'; padding-top: 20px">{{tipped_item}}/评论列表</div>
            <a-divider></a-divider>
          <div>
               <table >
                 <tr style="margin-bottom: 30px">
                   <td >序号</td>
                   <a-divider type="vertical" />
                   <td >被举报评论</td>
                   <a-divider type="vertical" />
                   <td >被举报的用户</td>
                   <a-divider type="vertical" />
                   <td >举报人</td>
                   <a-divider type="vertical" />
                   <td >举报时间</td>
                   <!-- <a-divider type="vertical" />
                   <td >操作</td> -->
                 </tr>
                 <tr v-for="item in tipped_comments" style="margin-bottom: 15px">
                  
                   <td><router-link :to="'/detail/' + item.ID">{{item.ID}}</router-link></td>

                   <a-divider type="vertical" />
                   <td>{{item.tipped_content}}</td>
                   <a-divider type="vertical" />
                   <td>{{item.tipped_user}}</td>
                   <a-divider type="vertical" />
                   <td>{{item.tip_user}}</td>
                   <a-divider type="vertical" />
                   <td>{{item.tip_time}}</td>
                   <!-- <a-divider type="vertical" />
                   <td>
                     <button @click="pass(item.ID)">同意</button>
                     <button @click="reject">否决</button>
                   </td> -->
                 </tr>
               </table>
            </div>
          </div>
        </a-layout-content>
</template>
<script>
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
            tipped_comments: datasource,
            tipped_item: '已审核举报'
        }
    }
}
</script>

