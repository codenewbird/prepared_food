<template>
    <div class="middle">
        <div class="query">
          <el-input style="width: 380px; float: left; margin: 0 10px" v-model="input" placeholder="Please input" />
          <el-button style="" class="submit" type="primary">Primary</el-button>
          <div id="main" style="height:400px; width:400px; margin: 10px auto"></div>
          <div id="main2" style="height:400px; width:400px; margin: 10px auto"></div>
        </div>
      </div>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue'
import { test } from '@/api/product.js'

let datachart = function () {
  var chartDom = document.getElementById('main');
  var myChart = echarts.init(chartDom);
  var option;

  option = {
    title: {
      text: '营养成分饼图',
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
        data: data1.value,
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

let data1 = ref([]);

onMounted(async () => {
    try {
        await test().then(res => {
          data1.value = res.data.compositionList.map(obj => {
            return {
                value: obj.dosage,
                name: obj.name
            };
          });
          datachart()
        })
    } catch (error) {
        
    }
    return {data1}
  })

const input = ref('')
const echarts = inject("echarts");
let datachart2 = function () {
  var chartDom = document.getElementById('main2');
  var myChart = echarts.init(chartDom);
  var option;

  option = {
    xAxis: {
      type: 'category',
      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        data: [120, 200, 150, 80, 70, 110, 130],
        type: 'bar'
      }
    ]
  };

  option && myChart.setOption(option);

};



onMounted(datachart2)
</script>