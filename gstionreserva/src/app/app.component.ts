import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {ProfesoresService} from './services/profesores/profesores.service'
import {ReservasService} from './services/reservas/reservas.service'
import {SalonesService} from './services/salones/salones.service'
import { error } from 'console';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  profesorForm: any;


  constructor(
    public fb: FormBuilder,
    public profesoresService: ProfesoresService,
    public reservasService: ReservasService,
    public salonesService: SalonesService
  ){

  }
  ngOnInit(): void {

    this.profesorForm = this.fb.group({
      documento: ['', Validators.required],
      tipoDocumento : ['',Validators.required],
      nombre: ['',Validators.required],
      email:['',Validators.email],
      telefono:['']

    })
  }

  guardar(): void{
    this.profesoresService.saveProfesor(this.profesorForm.value).subscribe(resp => {
      this.profesorForm.reset();
    },
      error=>{console.error(error)}
    )
  }
}
