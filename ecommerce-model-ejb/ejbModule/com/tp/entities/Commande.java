package com.tp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable{

	
	public Commande(){}
	
	public Commande(Date dateCommande, double prix, Client client, Collection<Produit> produits) {
		super();
		this.dateCommande = dateCommande;
		this.prix = prix;
		this.client = client;
		this.produits = produits;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "commandeId")
	    private int commandeId;

	    @Temporal(TemporalType.DATE)
	    private Date dateCommande = new Date();

	    private double prix;

	    @ManyToOne
	    @JoinColumn(name = "clientId")  //L'id défini dans la Class Client
	    private Client client;
	
	    @JoinTable(name="commandes_produits",
	    		   joinColumns=@JoinColumn(name="commandeId"),
	    		   inverseJoinColumns=@JoinColumn(name="produitId"))
	    private Collection <Produit> produits;

		public Date getDateCommande() {
			return dateCommande;
		}

		public void setDateCommande(Date dateCommande) {
			this.dateCommande = dateCommande;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public Collection<Produit> getProduits() {
			return produits;
		}

		public void setProduits(Collection<Produit> produits) {
			this.produits = produits;
		}

		@Override
		public String toString() {
			return "Commande [commandeId=" + commandeId + ", dateCommande=" + dateCommande + ", prix=" + prix
					+ ", client=" + client + ", Nombre de produits=" + produits.size() + "]";
		}
	    
	    
}

