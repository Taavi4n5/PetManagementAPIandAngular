import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {PetlistComponent} from './petlist/petlist.component';
import {PetService} from './pet.service';
import {AddpetComponent} from './addpet/addpet.component';
import {EditpetComponent} from './editpet/editpet.component';
import {SortPipe} from './petlist/sort.pipe';
import {AuthInterceptor} from './auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    PetlistComponent,
    LoginComponent,
    AddpetComponent,
    EditpetComponent,
    SortPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    PetService,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
