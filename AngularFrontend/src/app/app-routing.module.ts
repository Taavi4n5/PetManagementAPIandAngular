import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from './login/login.component'
import {PetlistComponent} from './petlist/petlist.component';
import {AddpetComponent} from './addpet/addpet.component';
import {EditpetComponent} from './editpet/editpet.component';
import {AuthGuard} from './auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'petlist', component: PetlistComponent, canActivate: [AuthGuard] },
  { path: 'addpet', component: AddpetComponent, canActivate: [AuthGuard] },
  { path: 'edit/:id', component: EditpetComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
