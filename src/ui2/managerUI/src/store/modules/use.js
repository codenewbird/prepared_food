import {login, loginout} from '@/api/user'
import storage from '@/util/storage.js'

const user = {
    state:{
        username: '',
        token: '',
    },
    getters:{
        isLogin(state){
            return state.username !== '' && state.token !== '';
        }
    },
    mutations:{
        SAVE_USER(state,username){
            state.username = username;
        },
        SAVE_TOKEN(state,token){
            state.token = token;
        },
    },
    actions:{
        LOGIN({commit},user){
            return new Promise(function(resolve,reject){
                login(user).then(res => {
                    console.log(res)
                    commit("SAVE_USER",res.data.user.username)
                    commit("SAVE_TOKEN",res.data.token)
                    storage.saveSessionObject("user",res.data)
                    resolve(res)
                })
            })
        },
        LOGINOUT({commit}){
            return new Promise(function(resolve,reject){
                loginout().then(res => {
                    // console.log(res)
                    commit("SAVE_USER",'')
                    commit("SAVE_TOKEN",'')
                    storage.remove("user")
                    resolve(res)
                })
            })
        },
        RECOVERY_USER({commit}){
            let user = storage.getSessionObject('user');
            if(user){
                commit("SAVE_TOKEN",user.token);
                commit("SAVE_USER",user.user.username);
            }
        }
    }
}

export default user