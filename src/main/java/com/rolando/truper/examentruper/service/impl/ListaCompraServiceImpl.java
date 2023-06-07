package com.rolando.truper.examentruper.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolando.truper.examentruper.model.ListaCompra;
import com.rolando.truper.examentruper.repository.IListaCompraRepository;
import com.rolando.truper.examentruper.service.IListaCompraService;

@Service
public class ListaCompraServiceImpl implements IListaCompraService{
	
	@Autowired
	private IListaCompraRepository iListaCompraRepository;
	
	@Override
	public ListaCompra createListaCompra(ListaCompra listaCompra) {
		return iListaCompraRepository.save(listaCompra);
	}

	@Override
	public Optional<ListaCompra> readListaCompraById(Long idListCompra) {
		return iListaCompraRepository.findById(idListCompra);
	}

	@Override
	public ListaCompra updateListaCompra(ListaCompra listaCompra) {
		return iListaCompraRepository.save(listaCompra);
	}

	@Override
	public void deleteClienteById(Long idListaCliente) {
		iListaCompraRepository.deleteById(idListaCliente);
	}

	@Override
	public List<ListaCompra> getCompraByIdCustomer(Long idCustomer) {
		return iListaCompraRepository.getListaCompraByIdCustomer(idCustomer);
	}

	@Override
	public Optional<ListaCompra> getLastListaCompraByCustomer(Long idCustomer) {
		return iListaCompraRepository.getLastListaCompraByIdCustomer(idCustomer);
	}

}
