import storage from '@/util/storage.js'

const lot = {
    state:{
        identificationCode:'',
        lot:'',
        lineId:'',
        state:'',
        num:''
    },
    getters:{
        
    },
    mutations:{
        SAVE_IDENTIFICATIONCODE(state,identificationCode){
            state.identificationCode = identificationCode;
        },
        SAVE_LOT(state,lot){
            state.lot = lot;
        },
        SAVE_LINEID(state,lineId){
            state.lineId = lineId;
        },
        SAVE_STATE(state,state2){
            state.state = state2;
        },
        SAVE_NUM(state,num){
            state.num = num;
        },
    },
    actions:{
        BEFORE({commit},lot){
            commit("SAVE_IDENTIFICATIONCODE",lot.identificationCode)
            commit("SAVE_LOT",lot.lot)
            commit("SAVE_LINEID",lot.lineId)
            commit("SAVE_STATE",lot.state)
            commit("SAVE_NUM",lot.num)
            storage.saveSessionObject("lot",lot)
        },
        RECOVERY_LOT({commit}){
            let lot = storage.getSessionObject('lot');
            console.log(lot)
            if(lot){
                commit("SAVE_IDENTIFICATIONCODE",lot.identificationCode)
                commit("SAVE_LOT",lot.lot)
                commit("SAVE_LINEID",lot.lineId)
                commit("SAVE_STATE",lot.state)
                commit("SAVE_NUM",lot.num);
            }
            return { lot }
        },
        SELECT_FOOD({commit},identificationCode){
            commit("SAVE_IDENTIFICATIONCODE",identificationCode)
            let lot = storage.getSessionObject('lot');
            lot.identificationCode = identificationCode
            storage.saveSessionObject("lot",lot)
        },
        SELECT_LINE({commit},lineId){
            commit("SAVE_LINEID",lineId)
            let lot = storage.getSessionObject('lot');
            lot.lineId = lineId
            storage.saveSessionObject("lot",lot)
        }
    }
}

export default lot