import Vue from 'vue'
import Router from 'vue-router'

import Home from './components/Home'
import Wacth from './components/prayer-watch/Watch'

Vue.use(Router)

export default new Router({
    routes: [
        { path: '/', component: Home },
        { path: '/watch', component: Wacth },
    ]
})