package com.curso.web.interfacesService;

import java.util.List;
import java.util.Optional;

import com.curso.web.modelo.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto save(Producto producto);
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
}
