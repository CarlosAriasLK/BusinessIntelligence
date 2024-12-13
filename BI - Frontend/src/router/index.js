import { createRouter, createWebHistory } from 'vue-router';
import Consumidor from '@/pages/Consumidor.vue';
import Productor from '@/pages/Productor.vue';
import Dashboard from '@/pages/Dashboard.vue';

const routes = [
    {
        path: '/',
        name: 'dashboard',
        component: Dashboard,
    },
    {
        path: '/consumidor',
        name: 'consumidor',
        component: Consumidor
    },
    {
        path: '/productor',
        name: 'productor',
        component: Productor,
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;