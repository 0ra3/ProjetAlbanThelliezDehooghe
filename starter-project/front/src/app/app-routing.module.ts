import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import { ProjectsComponent } from './projects/projects.component';
import { ProjetManagementComponent } from './projet-management/projet-management.component';
import { ProjetComponent } from './projet/projet.component';
import { CategoryComponent } from './category/category.component';
import { DonComponent } from './don/don.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'pm',
        component: PmComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {   
        path: 'projets', 
        component: ProjectsComponent
    },
    {
        path: 'projet/:id', 
        component: ProjetComponent
    },
    {
        path: 'nouveauprojet', 
        component : ProjetManagementComponent
    },
    {   
        path: 'find/:id',
        component: UserComponent
    },
    {
        path: 'category',
        component: CategoryComponent
    },
    {
        path: 'projet/:id/dons',
        component: DonComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
