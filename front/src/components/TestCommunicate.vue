<template>
    <div>
        <a-button type="primary" htmlType="submit" @click="handleSubmit">Submit</a-button>
    </div>
</template>

<script>
import axios from "axios";
export default {
  name: "TestCoummunicate",
  data() {
    return {
    };
  },
  methods: {
    /**处理提交 */
    handleSubmit: function() {
      axios({
        method: "post",
        url: "/test",
        headers: {
          // 'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        },
        transformRequest: [
          function(data) {
            let newData = "";
            for (let k in data) {
              newData +=
                encodeURIComponent(k) + "=" + encodeURIComponent(data[k]) + "&";
            }

            
            return newData;
          }
        ],
        data: {
          username: 5205,
          password: 123456
        }
      }).then(res => {
        console.log(res)
      });
    }
  }
};


</script>