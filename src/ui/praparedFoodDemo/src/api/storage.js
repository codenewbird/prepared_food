import request from ".";

export function test(query){
    return request({
        url: "/test7",
        method: "get",
        params: query
    })
}