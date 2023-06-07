package com.rolando.truper.examentruper.bean;

import java.util.List;

public class ListaCompraMO {
	
	private Long cliente;
	private String nombreLista;
	private List<ProductoMO> producto;
	
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
	public List<ProductoMO> getProducto() {
		return producto;
	}
	public void setProducto(List<ProductoMO> producto) {
		this.producto = producto;
	}
	
}
