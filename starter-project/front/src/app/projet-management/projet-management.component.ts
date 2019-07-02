import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Projet } from '../models/projet';
import { ProjetService } from '../services/projet.service';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-projet-management',
  templateUrl: './projet-management.component.html',
  styleUrls: ['./projet-management.component.css']
})
export class ProjetManagementComponent implements OnInit {
  projetForm : FormGroup;
  projects : Projet[];
  user : User;
  categories : Category[];
  categoryForm : FormGroup;

  constructor(private fb : FormBuilder, 
              private projetService : ProjetService,
              private userService : UserService,
              private categoryService : CategoryService,
              private tokenStorage : TokenStorageService
              ) { }

  ngOnInit() {
    this.initProjectForm();
    let un = this.tokenStorage.getUsername();
    if(un){
      console.log("found", un)
      this.findByUsername(un);
      this.findAll();
    }
  }

  initProjectForm() {
    this.projetForm = this.fb.group ({
      nom: [''],
      description : [''],
      budget: [''],
      category: [''],
      ressource: [''],
      image : [''],
    });
  }

  saveProjet(){
    let p: Projet= this.projetForm.value;
    p.user = this.user;
    p.ressource = 0;
    this.projetService.save(p).subscribe(res => {
                            this.initProjectForm();
                          });
  }

  findByUsername(username : string){
    console.log("outside");
    this.userService.findByUsername(username).subscribe(res =>{
      console.log("inside");
      console.log("current user", res)
      this.user = res;
      })
  }
  
  findAll(){
    return this.categoryService.findAll().subscribe(res =>{
    this.categories = res;
    });
  }
}
