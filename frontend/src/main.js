import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import Vuetify from 'vuetify'

Vue.use(Vuetify)
// index.js or main.js
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
// main.styl
//@import '~vuetify/src/stylus/main' // Ensure you are using stylus-loader


Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
