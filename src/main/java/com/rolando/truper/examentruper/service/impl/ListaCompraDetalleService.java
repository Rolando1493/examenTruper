package com.rolando.truper.examentruper.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolando.truper.examentruper.model.Key;
import com.rolando.truper.examentruper.model.ListaCompraDetalle;
import com.rolando.truper.examentruper.repository.IListaCompraDetalleRepository;
import com.rolando.truper.examentruper.service.IListaCompraDetalleService;

@Service
public class ListaCompraDetalleService implements IListaCompraDetalleService{

	@Autowired
	private IListaCompraDetalleRepository iListaCompraDetalleRepository;	
	@Override
	public ListaCompraDetalle createListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		return iListaCompraDetalleRepository.save(listaCompraDetalle);
	}

	@Override
	public Optional<ListaCompraDetalle> readListaCompraDetalleById(Key idListaCompraDetalle) {
		return iListaCompraDetalleRepository.findById(idListaCompraDetalle);
	}

	@Override
	public ListaCompraDetalle updateListaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		return iListaCompraDetalleRepository.save(listaCompraDetalle);
	}

	@Override
	public void deleteListaCompraDetalleById(Key idListaCompraDetalle) {
		iListaCompraDetalleRepository.deleteById(idListaCompraDetalle);
		
	}

}
