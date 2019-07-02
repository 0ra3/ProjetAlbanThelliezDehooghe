import { Component, OnInit, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Projet } from '../models/projet';
import { ProjetService } from '../services/projet.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  projets : Projet[];

  constructor( private projetService : ProjetService   ) { }


  
  ngOnInit() {
    this.findAll();
  }
  

  findAll() {
    return this.projetService.findAll().subscribe(res =>{
      console.log("test", res);
        this.projets = res;
    });
  }
}
