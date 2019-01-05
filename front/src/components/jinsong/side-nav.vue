<template>
<a-layout-sider >
            <a-menu
                @click="handleClick"
                theme = 'dark'
                :defaultSelectedKeys="['1']"
                :openKeys.sync="openKeys"
                mode="inline"
            >
                <a-sub-menu key="sub1" @titleClick="titleClick">
                <span slot="title"><a-icon type="mail" /><span>评论举报</span></span>
                  
                    <a-menu-item key="1" @click="unexamined">未审核举报</a-menu-item>
                  
                    <a-menu-item key="2" @click="examined">已审核举报</a-menu-item>               
                </a-sub-menu>

                <a-sub-menu key="sub2" @titleClick="titleClick">
                <span slot="title"><a-icon type="appstore" /><span>用户举报</span></span>
                <!-- <a-menu-item key="5">Option 5</a-menu-item>
                <a-menu-item key="6">Option 6</a-menu-item> -->
            
                </a-sub-menu>            
            </a-menu>
        </a-layout-sider>
</template>

<script>
export default {
  data () {
    return {
      current: ['mail'],
      openKeys: ['sub1'],
    }
  },
  methods: {
    handleClick (e) {
    },
    titleClick (e) {
    },
    unexamined: function(){
      this.tipped_item =  '未审核举报'
      this.$router.push('/tipped/unexamined')
    },
    examined: function(){
      this.tipped_item =  '已审核举报'
      this.$router.push('/tipped/examined')
    },

  },
  watch: {
    openKeys (val) {
    },
  },
}

</script>
