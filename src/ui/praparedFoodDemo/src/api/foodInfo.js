import request from ".";

export function getInfo(id){
    return request({
        'url': '/food/'+id,
        'method': 'get'
    })
}