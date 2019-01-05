import TestCommunicate from '../components/TestCommunicate.vue'
import SignUp from '../components/haihang/SignUp.vue'
import SignIn from '../components/haihang/SignIn.vue'
import Information from '../components/haihang/PersonalInformation.vue'
import Filelist from '../components/haihang/FileList.vue'
import Filedetail from '../components/haihang/FileDetail.vue'
import index from '../components/jinsong/index.vue'
import add_event from '../components/jinsong/add_event.vue'
import tipped from '../components/jinsong/tipped.vue'
import detail from '../components/jinsong/tipped_detail.vue'
import unexamined from '../components/jinsong/unexamined_tipped.vue'
import examined from '../components/jinsong/examined_tipped.vue'

let routers = [
    {
    path: "/",
    redirect: "/test"
    },
    //杨海航
    {
        path:"/test",
        component:TestCommunicate,
        name:"test"
    },
    {
        path:"/signup",
        component:SignUp,
        name:"signup"
    },
    {
        path:"/signin",
        component:SignIn,
        name:"signin"
    },
    {
        path:"/information",
        component:Information,
        name:"information"
    },
    {
        path:"/filelist",
        component:Filelist,
        name:"filelist"
    },
    {
        path:"/filedetail",
        component:Filedetail,
        name:"filedetail"
    },
    //杨劲松
    {
        path:'/index',
        component:index,
        name:'index'
    },
    {
        path:'/addEvent',
        name:'add_event',
        component:add_event
    },
    {
        path:'/tipped',
        component:tipped,
        children:[
            {
                path:'unexamined',
                component:unexamined
            },
            {
                path:'examined',
                component:examined
            }]
    },
    {
        path:'/detail/:tipped_id',
        name:'detail',
        component:detail
    }
];
export default routers