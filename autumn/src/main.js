import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store/index'
import VueRouter from 'vue-router'
import router from "./router";
import axios from 'axios';
import qs from 'qs';


//配置axios全局
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueRouter)

new Vue({
  render: h => h(App),
  store,
  router
}).$mount('#app')
