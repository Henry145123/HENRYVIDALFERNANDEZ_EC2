package com.idat.HenryVidalFernandezBodega.dto;

import com.idat.HenryVidalFernandezBodega.model.Producto;


public class BodegaDTORequest {

	
	private Integer id;
	
	private String nombreBodega;
	
	private String direccionBodega;
	
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public String getDireccionBodega() {
		return direccionBodega;
	}

	public void setDireccionBodega(String direccionBodega) {
		this.direccionBodega = direccionBodega;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
