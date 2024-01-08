<script setup>
import { RouterLink, RouterView } from 'vue-router'

    var ws = new WebSocket('ws://localhost:8080/websocket/2');
    // 获取连接状态
    console.log('ws连接状态：' + ws.readyState);
    //监听是否连接成功
    ws.onopen = function () {
        console.log('ws连接状态：' + ws.readyState);
        //连接成功则发送一个数据
        ws.send('test1');
    }
    // 接听服务器发回的信息并处理展示
    ws.onmessage = function (data) {
        console.log('接收到来自服务器的消息：');
        // console.log(data)
        window.alert(data.data)
        //完成通信后关闭WebSocket连接
    }
    // 监听连接关闭事件
    ws.onclose = function () {
        // 监听整个过程中websocket的状态
        console.log('ws连接状态：' + ws.readyState);
    }
    // 监听并处理error事件
    ws.onerror = function (error) {
        console.log(error);
    }

    let send = function (message){
        this.ws.send(JSON.stringify({
        id: 1,
        message: 'test',
        time: new Date().getTime()
    }))
    }
  

</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <nav>
        <RouterLink to="/foodManager">Home</RouterLink>
        <RouterLink to="/foodAdd">foodAdd</RouterLink>
        <RouterLink to="/lineAdd">lineAdd</RouterLink>
        <RouterLink to="/lineManager">lineManager</RouterLink>
        <RouterLink to="/lotAdd">lotAdd</RouterLink>
        <RouterLink to="/commentRuleSet">用户反馈监测规则设定</RouterLink>
      </nav>
    </div>
    <button >webSocket</button>
  </header>

  <RouterView />
</template>
