import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';


@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  public bloqueCentral = false;
  public bloqueaCrear = true;
  public bloqueaModifi = true;
  public bloqueaEliminar = true;
  constructor() {
  }
  eliUsuario={dni:0, nombre: ''};
  clien={dni:0, nombre: '', apellido: '', direccion: '', telefono: ''};
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
    console.log(this.clien);
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
    console.log(this.eliUsuario);
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;
  }
  cancelarEli(){
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;

  }
}

