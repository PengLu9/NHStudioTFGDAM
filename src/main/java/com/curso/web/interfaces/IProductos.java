package com.curso.web.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.web.modelo.Producto;

@Repository
public interface IProductos extends JpaRepository<Producto,Integer>{

}
