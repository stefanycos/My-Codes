import Vue from 'vue'
import App from './App.vue'

import './plugins/bootstrap'
import './plugins/axios'
import './plugins/sibar-menu'

import router from './router'
import store from './store/store'

Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
