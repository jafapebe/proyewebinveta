package com.init.products.entitys;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="movimientos")
public class Movimientos {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="mov_fecha", nullable=false)
	private Date mov_fecha;
	
	@Column(name="mov_cli_cedula", nullable=false, length=15)
	private String mov_cli_cedula;
	
	@Column(name="mov_usu_id", nullable=false, length=15)
	private Long mov_usu_id;
	
	@Column(name="mov_tipo", nullable=false, length=1)
	private String mov_tipo;
	
	@Column(name="arti_id", nullable=false, length=10)
	private Long arti_id;

	@Column(name="mov_cantidad", nullable=false)
	private Integer mov_cantidad;
	
	@Column(name="mov_precio", nullable=false)
	private double mov_precio;

	public Long getId() {
		return id;
	}

	public Long getArti_id() {
		return arti_id;
	}

	public void setArti_id(Long arti_id) {
		this.arti_id = arti_id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMov_fecha() {
		return mov_fecha;
	}

	public void setMov_fecha(Date mov_fecha) {
		this.mov_fecha = mov_fecha;
	}

	public String getMov_cli_cedula() {
		return mov_cli_cedula;
	}

	public void setMov_cli_cedula(String mov_cli_cedula) {
		this.mov_cli_cedula = mov_cli_cedula;
	}

	public Long getMov_usu_id() {
		return mov_usu_id;
	}

	public void setMov_usu_id(Long mov_usu_id) {
		this.mov_usu_id = mov_usu_id;
	}

	public String getMov_tipo() {
		return mov_tipo;
	}

	public void setMov_tipo(String mov_tipo) {
		this.mov_tipo = mov_tipo;
	}

	public Integer getMov_cantidad() {
		return mov_cantidad;
	}

	public void setMov_cantidad(Integer mov_cantidad) {
		this.mov_cantidad = mov_cantidad;
	}

	public double getMov_precio() {
		return mov_precio;
	}

	public void setMov_precio(double mov_precio) {
		this.mov_precio = mov_precio;
	}
	
	
}
