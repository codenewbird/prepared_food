import { createRouter, createWebHistory } from 'vue-router'
import FoodManager from '@/components/FoodManager.vue'
import FoodAdd from '@/components/FoodAdd.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/foodManager',
      name: 'foodManager',
      component: FoodManager
    },
    {
      path: '/foodAdd',
      name: 'foodAdd',
      component: FoodAdd
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
