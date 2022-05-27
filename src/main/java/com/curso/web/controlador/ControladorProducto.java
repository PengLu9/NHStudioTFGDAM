package com.curso.web.controlador;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.web.modelo.Producto;
import com.curso.web.modelo.Usuario;
import com.curso.web.service.ImageFileService;
import com.curso.web.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class ControladorProducto {

	private final Logger LOGGER = LoggerFactory.getLogger(ControladorProducto.class);
	
	@Autowired
	private ImageFileService upload;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/listaProducto";
	}
	//Crear Producto
	@GetMapping("/create")
	public String add() {
		return "productos/add";
	}
	//Guardar Producto
	@PostMapping("/save")
	public String save(Producto producto,@RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Prueba{}",producto);
		Usuario user = new Usuario(1,"","","","","","","");
		producto.setUsuario(user);
		
		//Imagen
		if(file.isEmpty()) {
			Producto producto2 = new Producto();
			producto2=productoService.get(producto.getId()).get();
			producto.setUrlImage(producto2.getUrlImage());
		}else {
			String nombreImagen=upload.saveImage(file);
			producto.setUrlImage(nombreImagen);
		}
		productoService.save(producto);
		return "redirect:/productos";
	}
	

	//Editar Producto
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		Producto producto = new Producto();
		Optional<Producto>optionalProducto=productoService.get(id);
		producto = optionalProducto.get();
		LOGGER.info("Prueba buscar{}",producto);
		model.addAttribute("producto",producto);
		return "productos/edit";
		
	}
	//Subir cambios
	@PostMapping("/update")
	public String update(Producto producto ,@RequestParam("img") MultipartFile file) throws IOException {
		if(file.isEmpty()) {//SI no se edita la imagen
			Producto producto2 = new Producto();
			producto2=productoService.get(producto.getId()).get();
			producto.setUrlImage(producto2.getUrlImage());
		}else {//Si se edita tambien la imagen
			
			Producto producto2 = new Producto();
			producto2=productoService.get(producto.getId()).get();
			//Eliminar imagen si no es la "Por defecto"
			if(producto.getUrlImage().equals("default.jpg")) {
				upload.deleteImage(producto.getUrlImage());
			}
			
			String nombreImagen=upload.saveImage(file);
			producto.setUrlImage(nombreImagen);
		}
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	//Eliminar producto
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		Producto producto = new Producto();
		producto=productoService.get(id).get();
		//Eliminar imagen si no es la "Por defecto"
		if(producto.getUrlImage().equals("default.jpg")) {
			upload.deleteImage(producto.getUrlImage());
		}
		productoService.delete(id);
		return "redirect:/productos";
	}
	
	
}
