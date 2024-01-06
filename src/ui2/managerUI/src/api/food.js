import request from ".";

export function test(){
    return request({
        url: "/food/test",
        method: "get",
    })
}

export function add(query){
    return request({
        url: "/food/add",
        method: "post",
        data: query
    })
}

export function getAllFoods(){
    return request({
        url: "/food/getAllFood",
        method: "get",
    })
}
