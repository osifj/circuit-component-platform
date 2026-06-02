import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/dashboard'
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: () => import('@/views/Dashboard.vue'),
    meta: { title: '系统概览' }
  },
  {
    path: '/component-info',
    name: 'ComponentInfo',
    component: () => import('@/views/ComponentInfo.vue'),
    meta: { title: '元件信息管理' }
  },
  {
    path: '/circuit-info',
    name: 'CircuitInfo',
    component: () => import('@/views/CircuitInfo.vue'),
    meta: { title: '电路信息管理' }
  },
  {
    path: '/param-match',
    name: 'ParamMatch',
    component: () => import('@/views/ParamMatch.vue'),
    meta: { title: '参数匹配' }
  },
  {
    path: '/debug-info',
    name: 'DebugInfo',
    component: () => import('@/views/DebugInfo.vue'),
    meta: { title: '调试信息' }
  },
  {
    path: '/alarm-info',
    name: 'AlarmInfo',
    component: () => import('@/views/AlarmInfo.vue'),
    meta: { title: '报警信息' }
  },
  {
    path: '/statistics',
    name: 'Statistics',
    component: () => import('@/views/Statistics.vue'),
    meta: { title: '数据统计' }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
