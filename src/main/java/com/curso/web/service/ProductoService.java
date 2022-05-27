package com.curso.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.web.interfaces.IProductos;
import com.curso.web.interfacesService.IProductoService;
import com.curso.web.modelo.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProductos productos;
	
	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productos.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return productos.findById(id);
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		productos.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productos.deleteById(id);
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productos.findAll();
	}

}
