import request from ".";

export function test(query){
    return request({
        url: "/test5",
        method: "get",
        params: query
    })
}

export function test6(query){
    return request({
        url: "/test6",
        method: "get",
        params: query
    })
}

export function test4(query){
    return request({
        url: "/test4",
        method: "get",
        params: query
    })
}

export function test3(query){
    return request({
        url: "/test3",
        method: "get",
        params: query
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