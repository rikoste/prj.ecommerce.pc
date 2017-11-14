package com.tp.entities;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId")
    private int clientId;
    private String nom;
    private String prenom;
    private String adresse;
    
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    
    public Client() {
    }

    public Client(Client client) {
        this.nom = client.nom;
        this.prenom = client.prenom;
        this.adresse = client.adresse;
        this.email = client.email;
        this.password = client.password;
       
    }

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", password=" + password + ", email=" + email + "]";
	}

	
	public String cryptWithMD5(String pass){
	    try {
	    	MessageDigest md;
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	       // Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}
