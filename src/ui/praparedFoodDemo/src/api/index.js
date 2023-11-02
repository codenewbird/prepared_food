import axios from "axios";
// import store from "@/store";

const request = axios.create({
    baseURL: '/api',
    timeout: 10000,
    headers: {'Content-Type': 'application/json;charset=utf-8'}
})

// 添加请求拦截器
// request.interceptors.request.use(function (config) {

//     if(store.state.user.token){
//         config.headers['Authorization'] = store.state.user.token
//         config.headers['username'] = store.state.user.username
//     }
//     // 在发送请求之前做些什么
//     return config;
//   }, function (error) {
//     // 对请求错误做些什么
//     return Promise.reject(error);
//   }); 

export default request