import HelloWorld from '../components/HelloWorld.vue'
import TestComunicate from '../components/TestComunicate.vue'

let routers = [
    {
    path: "/",
    redirect: "/test"
    },
    {
        path: "/hello",
        component: HelloWorld,
        name: "hello"
    },
    {
        path:"/test",
        component:TestComunicate,
        name:"test"
    },
];
export default routers