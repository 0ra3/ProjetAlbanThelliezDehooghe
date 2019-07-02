import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { donService } from '../services/don.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Don } from '../models/don';
import { ProjetService } from '../services/projet.service';
import { Projet } from '../models/projet';


@Component({
  selector: 'app-don',
  templateUrl: './don.component.html',
  styleUrls: ['./don.component.css']
})

export class DonComponent implements OnInit {
  donForm : FormGroup;
  projetId : number;
  projetEditForm : FormGroup;
  projetForm : FormGroup;
  projet : Projet;


  constructor(private fb : FormBuilder,
              private router : ActivatedRoute,
              private route : Router,
              private donService : donService,
              private projetService : ProjetService,     
    ) { }

  ngOnInit() {
    this.initDonForm();
    this.router.paramMap.subscribe(res => {
      this.projetId = +res.get('id');
      this.findById(this.projetId);
    });
  }

  initDonForm(){
    this.donForm=this.fb.group({
      montant :['']
    });
  }

  save() {
    let don : Don= this.donForm.value;
    don.projet=this.projet;
    this.donService.save(don).subscribe(res => {
      this.updateProjet();
      this.initDonForm();
    });
  }

  findById(id : number){
    this.projetService.findById(id).subscribe(res =>{
      this.projet=res;
    })
  }

  updateProjet (){
    this.projet.ressource = this.projet.ressource + this.donForm.value.montant;
    this.projetService.save(this.projet).subscribe(res=> {
      this.projet = res;
      this.route.navigate(['projets']);
    });
  }
}
