import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { Layout } from './pages/layout/layout';
import { Dashboard } from './pages/dashboard/dashboard';
import { AgentDashboard } from './pages/dashboard/agent/agent-dashboard';
import { ClientDashboard } from './pages/dashboard/client/client-dashboard';
export const routes: Routes = [
    {
        path:'',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: Login
    },
    {
        path: '',
        component:Layout,
        children: [
            {
                path:'dashboard/client',
                component: ClientDashboard
            },
            {
                path: 'dashboard/agent',
                component: AgentDashboard
            }]    
    }
];
