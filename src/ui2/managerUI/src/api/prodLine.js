import request from ".";


export function addLine(query){
    return request({
        url: "/line/add", 
        method: "post",
        data: query
    })
}