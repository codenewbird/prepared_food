import request from ".";


export function addLine(query){
    return request({
        url: "/line/add", 
        method: "post",
        data: query
    })
}

export function getAllLine(){
    return request({
        url: "/line/getAllLine", 
        method: "get",
    })
}