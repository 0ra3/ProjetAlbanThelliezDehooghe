package com.joseway.ngspringsec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String nom;
		private String description;
		private Long budget;
		private Long ressource;
		private String image;
		

		@ManyToOne
		private User user;
		
		
		@OneToMany(mappedBy="projet", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		private List<Don> don;
		
		
		@ManyToOne (cascade=CascadeType.DETACH)
		private Category category;
		

		
		public Projet () {}


		
		public Projet(Long id, String nom, String description, Long budget, Long ressource, String image) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.budget = budget;
			this.ressource = ressource;
			this.image = image;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getBudget() {
			return budget;
		}

		public void setBudget(Long budget) {
			this.budget = budget;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public List<Don> getDon() {
			return don;
		}

		public void setDon(List<Don> don) {
			this.don = don;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}


		public Long getRessource() {
			return ressource;
		}


		public void setRessource(Long ressource) {
			this.ressource = ressource;
		}



		public String getImage() {
			return image;
		}



		public void setImage(String image) {
			this.image = image;
		}

		
}
