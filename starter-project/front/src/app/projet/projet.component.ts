import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProjetService } from '../services/projet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Projet } from '../models/projet';


@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.css']
})
export class ProjetComponent implements OnInit {
projetId :number;
projet : Projet;
projetEditForm : FormGroup;
donEditForm :FormGroup;

  constructor(private ps : ProjetService, 
    private router : ActivatedRoute,
    private fb : FormBuilder,
    private route : Router,
   ) { }

  ngOnInit() {
    this.router.paramMap.subscribe(res => {
      this.projetId = +res.get('id');     
      this.findById(this.projetId);
    });
  }

    initProjectEditForm(){
      this.projetEditForm= this.fb.group({
        nom:[this.projet.nom],
        description:[this.projet.description],
       budget:[this.projet.budget],
       dons: [this.projet.don],
       ressource:[this.projet.ressource],
       image : [this.projet.image]
      });
    }

    findById(id : number){
      this.ps.findById(id).subscribe(res =>{
        this.projet=res;
        this.initProjectEditForm();
      })
    }

    deleteProjet(id: number){
        this.ps.delete(id).subscribe( res => {   
        })
        this.route.navigate(['/projets'])
    }
}
