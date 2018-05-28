import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ClienteComponent } from './cliente/cliente.component';
import { VehiculoComponent } from './vehiculo/vehiculo.component';
import { RepuestoComponent } from './repuesto/repuesto.component';
import {RouterModule, Router} from '@angular/router'
@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    VehiculoComponent,
    RepuestoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot( [
      {path: 'cliente', component: ClienteComponent},
      {path:'vehiculo', component: VehiculoComponent},
      {path:'repuesto', component: RepuestoComponent},
    ]
  )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
