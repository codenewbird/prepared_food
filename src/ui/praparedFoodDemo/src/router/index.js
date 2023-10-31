import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MonitorView from '../views/MonitorView.vue'
import WorkingProcedures from '../views/WorkingProceduresView.vue'
import RawMaterialsView from '../views/RawMaterialsView.vue'
import TransportInfoView from '../views/TransportInfoView.vue'
import SaleInfoPageView from '../views/SaleInfoPageView.vue'

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
      component: MonitorView
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
