import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('./views/Index.vue')
    },
    {
      path: '/Autenticar',
      name: 'login',
      component: () => import('./views/Login.vue')
    },
    {
      path: '/Registar',
      name: 'registar',
      component: () => import('./views/Registar.vue')
    }
  ]
})
