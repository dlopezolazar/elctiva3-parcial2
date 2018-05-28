import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-repuesto',
  templateUrl: './repuesto.component.html',
  styleUrls: ['./repuesto.component.css']
})
export class RepuestoComponent implements OnInit {

  public bloqueCentral = false;
  public bloqueaCrear = true;
  public bloqueaModifi = true;
  public bloqueaEliminar = true;
  constructor() {
  }
  elirepu={cod_repuesto:''};
  repu={cod_repuesto:'', nombre: '', precio: 0};
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
    console.log(this.repu);
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
    console.log(this.elirepu);
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;
  }
  cancelarEli(){
    this.bloqueaEliminar = true;
    this.bloqueCentral = false;

  }

}
