package com.joseway.ngspringsec.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Don {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private Integer montant;
		
		@JsonIgnore
		@ManyToOne
		private Projet projet;
		
		public Don() {}

		
		
		
		public Don(Long id, Integer montant, Projet projet) {
			super();
			this.id = id;
			this.montant = montant;
			this.projet = projet;
		}




		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getMontant() {
			return montant;
		}

		public void setMontant(int montant) {
			this.montant = montant;
		}

		public Projet getProjet() {
			return projet;
		}

		public void setProjet(Projet projet) {
			this.projet = projet;
		}
		
}
