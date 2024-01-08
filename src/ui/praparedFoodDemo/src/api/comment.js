import request from ".";

export function getComments(identificationCode){
    return request({
        url: "/comment/"+identificationCode,
        method: "get",
    })
}