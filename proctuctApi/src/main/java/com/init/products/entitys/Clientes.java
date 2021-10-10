package com.init.products.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NombreCli", nullable=false, length=70)
	private String NombreCli;
	
	@Column(name="AddressCli", nullable=false, length=70)
	private String AddressCli;
	
	@Column(name="CiudadCli", nullable=false, length=25)
	private String CiudadCli;
	
	@Column(name="EmailCli", nullable=false, length=70)
	private String EmailCli;
	
	@Column(name="TelefonoCli", nullable=false, length=25)
	private long TelefonoCli;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCli() {
		return NombreCli;
	}

	public void setNombreCli(String nombreCli) {
		NombreCli = nombreCli;
	}

	public String getAddressCli() {
		return AddressCli;
	}

	public void setAddressCli(String addressCli) {
		AddressCli = addressCli;
	}

	public String getCiudadCli() {
		return CiudadCli;
	}

	public void setCiudadCli(String ciudadCli) {
		CiudadCli = ciudadCli;
	}

	public String getEmailCli() {
		return EmailCli;
	}

	public void setEmailCli(String emailCli) {
		EmailCli = emailCli;
	}

	public long getTelefonoCli() {
		return TelefonoCli;
	}

	public void setTelefonoCli(long telefonoCli) {
		TelefonoCli = telefonoCli;
	}
	

}
