import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Projet } from '../models/projet';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {
private projetsUrl : string = 'http://localhost:8080/api/projets';

  constructor(private http : HttpClient) { }

  findAll(): Observable<Projet[]>{
    return this.http.get<Projet[]>(this.projetsUrl);
  }

  findById(id : number) : Observable<Projet>{
    return this.http.get<Projet>(this.projetsUrl + '/' + id );
  }

  save (projet : Projet) : Observable<Projet>{
    return this.http.post<Projet>(this.projetsUrl, projet);
  }

  delete ( id: number) : Observable<Projet>{
    return this.http.get<Projet>(this.projetsUrl + '/' + id + '/delete');
  }
}