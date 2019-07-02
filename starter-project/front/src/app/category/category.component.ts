import { Component, OnInit } from '@angular/core';
import { Category } from '../models/category';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CategoryService } from '../services/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
categories : Category[];
categoryForm : FormGroup;
categorie : Category;

  constructor(private fb : FormBuilder, 
              private categoryService : CategoryService,
              private route : Router
              ) {}

  ngOnInit() {
    this.initCategoryForm();
    this.findAll();
    this.findById;
  }

  initCategoryForm() {
    this.categoryForm = this.fb.group({
      nom : ['']
    });
  }

  findAll(){
    return this.categoryService.findAll().subscribe(res =>{
    this.categories = res;
    });
  }

  save(){
    let cat : Category = this.categoryForm.value;
    return this.categoryService.save(cat).subscribe(res => {
    this.categoryForm;
    })
  }

  delete(id: number){
    this.categoryService.delete(id).subscribe( res => {   
    })
    this.route.navigate(['/category'])
}

findById(id : number){
  this.categoryService.findById(id).subscribe(res =>{
    this.categorie=res;
  })
}
}
