package com.rolando.truper.examentruper.service;

import java.util.Optional;

import com.rolando.truper.examentruper.model.Key;
import com.rolando.truper.examentruper.model.ListaCompraDetalle;

public interface IListaCompraDetalleService {

	public ListaCompraDetalle createListaCompraDetalle(ListaCompraDetalle listaCompraDetalle);
	
	public Optional<ListaCompraDetalle> readListaCompraDetalleById(Key idListaCompraDetalle);
	
	public ListaCompraDetalle updateListaCompraDetalle(ListaCompraDetalle listaCompraDetalle);
	
	public void deleteListaCompraDetalleById(Key idListaCompraDetalle);
	
}
