<template>
  <div class="left"></div>
  <div class="middle">
    <div class="query">
      <el-input style="width: 380px; float: left; margin: 0 10px" v-model="input" placeholder="Please input" />
      <el-button style="" class="submit" type="primary">Primary</el-button>
      <div id="main" style="height:400px; width:400px"></div>
    </div>
  </div>
  <div class="right"></div>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue'
const input = ref('')
const echarts = inject("echarts");

let datachart = function () {
  var chartDom = document.getElementById('main');
  var myChart = echarts.init(chartDom);
  var option;

  option = {
    title: {
      text: 'Referer of a Website',
      subtext: 'Fake Data',
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: [
          { value: 1048, name: 'Search Engine' },
          { value: 735, name: 'Direct' },
          { value: 580, name: 'Email' },
          { value: 484, name: 'Union Ads' },
          { value: 300, name: 'Video Ads' }
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };

  option && myChart.setOption(option);

}

onMounted(datachart)

</script>

<style scope>
.left{
  float: left;
  width: 33%;
  height: 300px;
  background-color: red;
}
.middle{
  float: left;
  width: 33%;
  height: 300px;
  background-color: blue;
}
.right{
  float: left;
  width: 33%;
  height: 300px;
  background-color: green;
}
</style>
