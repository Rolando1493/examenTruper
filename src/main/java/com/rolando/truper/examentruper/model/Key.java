package com.rolando.truper.examentruper.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Key implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7208685047886829233L;
	
	private Long idListaCompra;
	private Long codigoProducto;
	
	public Long getIdListaCompra() {
		return idListaCompra;
	}
	public void setIdListaCompra(Long idListaCompra) {
		this.idListaCompra = idListaCompra;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
}
