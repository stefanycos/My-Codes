import Vue from 'vue'
import Router from 'vue-router'
import Goals from '@/components/Goals'
import Accounts from '@/components/Accounts'
import Investments from '@/components/Investments'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'investments',
      component: Investments
    },
    {
      path: '/goals',
      name: 'goals',
      component: Goals
    },
    {
      path: '/accounts',
      name: 'accounts',
      component: Accounts
    }
  ]
})
