package com.rolando.truper.examentruper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolando.truper.examentruper.model.Key;
import com.rolando.truper.examentruper.model.ListaCompraDetalle;

@Repository
public interface IListaCompraDetalleRepository extends JpaRepository<ListaCompraDetalle, Key>{

}
