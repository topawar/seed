import VueRouter from 'vue-router'
import Register from '../components/Register'


export default new VueRouter({
    routes:[
        {
            path:'/',
            redirect:'/register'
        },
        {
            path:'/register',
            name:'register',
            component:Register,
        },
        {
            path:'/index',
            name:'index',
            component: ()=> import ('@/views/index')
        }
    ]
})