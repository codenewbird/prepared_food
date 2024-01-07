import request from ".";

export function addlot(query){
    request({
        "url": "/lot/add",
        "method": "post",
        "data": query
    })
}