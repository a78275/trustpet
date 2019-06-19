import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

Vue.config.productionTip = false
Vue.use(require('vue-script2'))

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
