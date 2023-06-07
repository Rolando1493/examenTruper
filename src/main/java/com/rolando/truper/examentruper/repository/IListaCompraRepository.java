package com.rolando.truper.examentruper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rolando.truper.examentruper.model.ListaCompra;

@Repository
public interface IListaCompraRepository extends JpaRepository<ListaCompra, Long>{
	
	@Query( value = "select lc from ListaCompra lc where ListaCompra.id_cliente = :idCustomer", nativeQuery = true)
	public List<ListaCompra> getListaCompraByIdCustomer(@Param(value = "idCustomer") Long idCustomer);
	
	@Query( value = "select lc from ListaCompra lc where ListaCompra.id_cliente=:idCustomer and max(fecha_alta) and "
			+ "fecha_ultima_actualizacion is null", nativeQuery = true)
	public Optional<ListaCompra> getLastListaCompraByIdCustomer(Long idCustomer);
	 
}
