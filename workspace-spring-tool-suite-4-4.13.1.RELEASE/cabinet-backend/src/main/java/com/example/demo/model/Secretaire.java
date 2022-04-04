package com.example.demo.model;
import javax.persistence.*;
@Entity
@Table(name="secretaire")
public class Secretaire {	
	
	public Secretaire() {}
	
		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		public Secretaire(String nom, String prenom, long age, String telephone, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		@Column(name="nom")
		private String nom;
		@Column(name="prenom")
		private String prenom;
		@Column(name="age")
		private long age;
		@Column(name="telephone")
		private String telephone;
		@Column(name="email")
		private String email;
		@Column(name="password")
		private String password;
}

