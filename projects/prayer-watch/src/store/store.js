import Vue from 'vue'
import Vuex from 'vuex'

import hours from './hours'

import register_prayer from './modules/register_prayer'

Vue.use(Vuex)

export default new Vuex.Store({
    hours,
    modules: {
        register_prayer
    }
})