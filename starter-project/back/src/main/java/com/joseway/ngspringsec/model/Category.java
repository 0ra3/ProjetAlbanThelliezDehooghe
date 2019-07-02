package com.joseway.ngspringsec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String nom;
		
		@JsonIgnore
		@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
		private List<Projet> projet;
		
		
		public Category() {}
		
		

		public Category(Long id, String nom, List<Projet> projet) {
			super();
			this.id = id;
			this.nom = nom;
			this.projet = projet;
		}

		public Long getId() {
			return id;
		}

		public List<Projet> getProjet() {
			return projet;
		}

		public void setProjet(List<Projet> projet) {
			this.projet = projet;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
		
}
