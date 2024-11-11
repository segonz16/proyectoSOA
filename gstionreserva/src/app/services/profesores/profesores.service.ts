import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfesoresService {
  private API_SERVER= "http://localhost:9000/api/profesores/"

  constructor(private httpClient: HttpClient) { }

  public getProfesorById(documento: any): Observable<any> {
    return this.httpClient.get(this.API_SERVER + documento);
  }

  public getAllProfesores(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveProfesor(profesor: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER+"guardar", profesor);
  }

}


