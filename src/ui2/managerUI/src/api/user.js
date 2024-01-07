import request from ".";

export function test(query){
    return request({
        url: "/test",
        method: "get",
        params: query
    }).then(res => {
        console.log(res)
    })
}

export function login(data){
    return request({
        url: "/login",
        method: "post",
        data: data
    })
}

export function loginout(data){
    return request({
        url: "/loginout",
        method: "get"
    })
}

export function getInfo(){
    return request({
        url: "/user/getInfo",
        method: "get"
    })
}

export function getUserInfo(userId){
    return request({
        url: "/user/"+userId,
        method: "get"
    })
}