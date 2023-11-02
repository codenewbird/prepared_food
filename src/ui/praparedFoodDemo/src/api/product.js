import request from ".";



export function getNutrition(query){
    return request({
        url: "/getNutrition",
        method: "get",
        params: query
    })
}

export function getRawMaterial(query){
    return request({
        url: "/getRawMaterial",
        method: "get",
        params: query
    })
}

export function getIngredient(query){
    return request({
        url: "/getIngredient",
        method: "get",
        params: query
    })
}

export function getBaseInfo(query){
    return request({
        url: "/getBaseInfo",
        method: "get",
        params: query
    })
}

export function getProductionLineInfo(query){
    return request({
        url: "/getProductionLineInfo",
        method: "get",
        params: query
    })
}
