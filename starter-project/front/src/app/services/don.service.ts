import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Don } from '../models/don';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class donService {
private donUrl : string = "http://localhost:8080/api/dons";

  constructor( private http : HttpClient) { }

  findAll(): Observable<Don[]>{
    return this.http.get<Don[]>(this.donUrl);
  }

  save(don : Don): Observable<Don>{
    return this.http.post<Don>(this.donUrl, don);
  }

  findById(id : number): Observable<Don>{
    return this.http.get<Don>(this.donUrl + '/' + id);
  }
}
