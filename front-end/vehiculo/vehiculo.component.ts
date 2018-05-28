import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css']
})
export class VehiculoComponent implements OnInit {

  public bloqueCentral = false;
  public bloqueaCrear = true;
  public bloqueaModifi = true;
  public bloqueaEliminar = true;
  constructor() {
  }
  eliVehi={matricula:'', cedula: 0};
  vehi={matricula:'', cedula: 0, modelo: '', color: '', fecha_entrada: Date()};
  crear(){
    this.bloqueaCrear = false;
    this.bloqueCentral = true;
  }
  modificar(){}

  ngOnInit() {
    this.bloqueaCrear = true;
    this.bloqueaModifi = true;
    this.bloqueaEliminar = true;
  }
  //para crear
  guardarCli(){
    console.log(this.vehi);
    this.bloqueaCrear = true;
    this.bloqueCentral = false;
  }
  cancelarCli(){
    this.bloqueaCrear = true;
    this.bloqueCentral = false;

  }
  //para eliminar
  eliminar(){
    this.bloqueCentral = true;
    this.bloqueaEliminar = false;
  }

  eliminarCli(){
    console.log(this.eliVehi);
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;
  }
  cancelarEli(){
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;

  }
}
