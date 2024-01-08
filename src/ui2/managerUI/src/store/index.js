import { createStore } from "vuex"
import user from "./modules/use"
import lot from "./modules/lot"
import actions from '@/actions'
import mutations from '@/mutations'

const store = createStore({
    modules:{
        lot,user
    },
    actions,
    mutations
})

export default store