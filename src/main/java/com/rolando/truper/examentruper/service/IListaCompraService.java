package com.rolando.truper.examentruper.service;

import java.util.List;
import java.util.Optional;

import com.rolando.truper.examentruper.model.ListaCompra;

public interface IListaCompraService {

	public ListaCompra createListaCompra(ListaCompra listaCompra);
	
	public Optional<ListaCompra> readListaCompraById(Long idListCompra);
	
	public ListaCompra updateListaCompra(ListaCompra listaCompra);
	
	public void deleteClienteById(Long idListaCliente);
	
	public List<ListaCompra> getCompraByIdCustomer(Long idCustomer);
	
	public Optional<ListaCompra> getLastListaCompraByCustomer(Long idCustomer);
	
}
