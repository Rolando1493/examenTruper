package com.rolando.truper.examentruper.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolando.truper.examentruper.model.Producto;
import com.rolando.truper.examentruper.repository.IProductRepository;
import com.rolando.truper.examentruper.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductRepository iProductoRepository;
	
	@Override
	public Producto createProducto(Producto producto) {
		return iProductoRepository.save(producto);
	}

	@Override
	public Optional<Producto> getProductoByid(Long idProducto) {
		return iProductoRepository.findById(idProducto);
	}

	@Override
	public Producto udpateProducto(Producto producto) {
		return iProductoRepository.save(producto);
	}

	@Override
	public void deleteProductoById(Long idProducto) {
		iProductoRepository.deleteById(idProducto);
	}

}
