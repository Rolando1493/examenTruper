package com.rolando.truper.examentruper.service;

import java.util.Optional;

import com.rolando.truper.examentruper.model.Producto;

public interface IProductoService {
	
	public Producto createProducto(Producto producto);
	
	public Optional<Producto> getProductoByid(Long idProducto);
	
	public Producto udpateProducto(Producto producto);
	
	public void deleteProductoById(Long idProducto);
	
}
