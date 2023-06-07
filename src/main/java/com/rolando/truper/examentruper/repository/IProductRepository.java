package com.rolando.truper.examentruper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolando.truper.examentruper.model.Producto;

@Repository
public interface IProductRepository extends JpaRepository<Producto, Long>{  

}
