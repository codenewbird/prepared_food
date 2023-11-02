import request from ".";

export function getStorageRecord(query){
    return request({
        url: "/getStorageRecord",
        method: "get",
        params: query
    })
}