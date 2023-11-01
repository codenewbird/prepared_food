import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MonitorView from '../views/MonitorView.vue'
import WorkingProcedures from '../views/WorkingProceduresView.vue'
import RawMaterialsView from '../views/RawMaterialsView.vue'
import TransportInfoView from '../views/TransportInfoView.vue'
import SaleInfoPageView from '../views/SaleInfoPageView.vue'
import MonitorDishView from '../components/monitor/MonitorDishView.vue'
import MonitorRawView from '../components/monitor/MonitorRawView.vue'
import MonitorTranView from '../components/monitor/MonitorTranView.vue'
import { transform } from '@vue/compiler-core'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomeView
    },
    {
      path: '/monitor',
      name: 'monitor',
      component: MonitorView,
      children:[
        {
          path:'/dish',
          name:'dish',
          component:MonitorDishView
        },
        {
          path:'/raw',
          name:'raw',
          component:MonitorRawView
        },
        {
          path:'tran',
          name:tran,
          component:MonitorTranView
        }
      ]
    },
    {
      path: '/workprocedure',
      name: 'workprocedure',
      component: WorkingProcedures
    },
    {
      path: '/rawmaterial',
      name: 'rawmaterial',
      component: RawMaterialsView
    },
    {
      path: '/transportinfo',
      name: 'transportinfo',
      component: TransportInfoView
    },
    {
      path: '/saleinfo',
      name: 'saleinfo',
      component: SaleInfoPageView
    },
  ]
})

export default router
