export default {
    saveSessionString(key,value){
        window.sessionStorage.setItem(key,value)
    },
    getSessionString(key,value){
        return window.sessionStorage.getItem(key)
    },
    saveSessionObject(key,value){
        window.sessionStorage.setItem(key,JSON.stringify(value))
    },
    getSessionObject(key,value){
        return JSON.parse(window.sessionStorage.getItem(key))
    },
    remove(key){
        return window.sessionStorage.removeItem(key)
    },
} 