package com.init.products.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedores {

	@Id
	@Column(name= "Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NombreProv", nullable=false, length=70)
	private String NombreProv;
	
	@Column(name="AddressProv", nullable=false, length=70)
	private String AddressProv;
	
	@Column(name="CiudadProv", nullable=false, length=70)
	private String CiudadProv;
	
	@Column(name="EmailProv", nullable=false, length=70)
	private String EmailProv;
	
	@Column(name="TelefonoProv", nullable=false, length=70)
	private String TelefonoProv;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreProv() {
		return NombreProv;
	
	}
	
	public void setNombreProv(String nombreProv) {
		NombreProv = nombreProv;
	}
	public String getAddressProv() {
		return AddressProv;
	}
	public void setAddressProv(String addressProv) {
		AddressProv = addressProv;
	}
	public String getCiudadProv() {
		return CiudadProv;
	}
	public void setCiudadProv(String ciudadProv) {
		CiudadProv = ciudadProv;
	}
	public String getEmailProv() {
		return EmailProv;
	}
	public void setEmailProv(String emailProv) {
		EmailProv = emailProv;
	}
	public String getTelefonoProv() {
		return TelefonoProv;
	}
	public void setTelefonoProv(String telefonoProv) {
		TelefonoProv = telefonoProv;
	}
	
}
