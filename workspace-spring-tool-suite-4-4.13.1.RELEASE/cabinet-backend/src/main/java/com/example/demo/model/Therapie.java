package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="therapie")
public class Therapie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="nom")
	private String nom;
	@Column(name="desription")
	private String description;
	@Column(name="image")
	private String image;
	@Column(name="video")
	private String video;
	
	public Therapie() {}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public Therapie(String nom, String description, String image, String video) {
		super();
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.video = video;
	}

}
