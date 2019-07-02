import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
private categoryUrl : string = 'http://localhost:8080/api/category'
  constructor(private http : HttpClient) { }

  findAll(): Observable<Category[]>{
    return this.http.get<Category[]>(this.categoryUrl);
  }
  
  save(category : Category): Observable<Category>{
    return this.http.post<Category>(this.categoryUrl, category);
  }

  delete(id : number): Observable<Category> {
    return this.http.get<Category>(this.categoryUrl + '/' + id + '/delete');
  }

  findById( id : number) : Observable<Category>{
    return this.http.get<Category>(this.categoryUrl + '/' + id);
  }
}
