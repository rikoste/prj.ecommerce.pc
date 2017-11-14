package com.tp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name = "produits")
public class Produit {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produitId")
    private int produitId;
    private String nom;
    private String description;
    private String image;
    private double prix;

    @Min(0) 
    private int stock;

    
    public Produit(){};
    
	@Override
	public String toString() {
		return "Produit [produitId=" + produitId + ", nom=" + nom + ", description=" + description + ", image=" + image
				+ ", prix=" + prix + ", stock=" + stock + "]";
	}

	public Produit(String nom, String description, String image, double prix, int stock) {
		super();
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.prix = prix;
		this.stock = stock;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

   
}
