import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions ={}

const mutations={}

const state={
    isLoginFlag: false
}

const store = new Vuex.Store({
    actions,
    mutations,
    state
})


export default store