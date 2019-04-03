package com.serieManager.serieManagerList.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //avec ibernate il génère cette class en table
public class Serie {
	private @Id @GeneratedValue Long id;
	private String nom;
	private String numero;
	private String acteurPrincipalSerie;
	private String voOuNon;

	public Serie(){}
	
	public Serie(String nom,String numero,String acteurPrincipalSerie,String voOuNon){
		this.nom = nom;
		this.numero = numero;
		this.acteurPrincipalSerie = acteurPrincipalSerie;
		this.voOuNon = voOuNon;
	}
	
	public Long getNumList(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public String getActeurPrincipalSerie(){
		return this.acteurPrincipalSerie;
	}
	
	public String getVoOuNon(){
		return this.voOuNon;
	}

	public void setId(Long id2) {
		this.id = id2;
		
	}

	public void setNom(String nom2) {
		this.nom = nom2;
		
	}

	public void setNumero(String numero2) {
		this.numero = numero2;
		
	}

	public void setActeurPrincipalSerie(String acteurPrincipalSerie2) {
		this.acteurPrincipalSerie = acteurPrincipalSerie2;
		
	}

	public void setVoOuNon(String voOuNon2) {
		this.voOuNon = voOuNon2;
		
	}
}
