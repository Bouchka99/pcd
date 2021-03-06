package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="patient")
public class Patient {

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
	@Column(name="cin")
	private String cin;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String nom, String prenom, long age, String telephone, String email, String password, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.cin = cin;
	}
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	
}