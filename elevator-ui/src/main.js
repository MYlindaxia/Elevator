import Vue from 'vue'
import App from "./App.vue"
import router from './router'
import store from './store'
import "element-ui/lib/theme-chalk/index.css"
import http from "./http/http"
import axios from "axios"

Vue.config.productionTip = false
Vue.prototype.$axios = axios

new Vue({
  router,
  store,
  http,
  render: function (h) { return h(App) }
}).$mount('#app')
