import Vue from 'vue'
import VueRouter from 'vue-router'
import elementui from "element-ui"
const main = () => import("../components/main.vue")
const login = () => import("../components/login.vue")
const order = () => import("../components/order.vue")
const user = () => import("../components/user.vue")
const elevator = () => import("../components/elevator.vue")

Vue.use(VueRouter)
Vue.use(elementui)

const routes = [
  {
    path: "/",
    component: login
  },
  {
    path: "/main",
    component: main,
    children: [
      {
        path: "/main/order",
        component: order
      },
      {
        path: "/main/user",
        component: user
      },
      {
        path: "/main/elevator",
        component: elevator
      }
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next) => {
  
  if(to.fullPath === "/") {
    next();
  }else {
    
    if(window.sessionStorage.getItem("token") !== null) {
      next();
    }else {
      next("/");
    }
  }
})

export default router
