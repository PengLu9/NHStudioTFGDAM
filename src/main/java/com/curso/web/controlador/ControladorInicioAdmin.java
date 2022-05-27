package com.curso.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.web.modelo.Producto;
import com.curso.web.service.ProductoService;

@Controller
@RequestMapping
public class ControladorInicioAdmin {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/inicio")
	public String inicio() {

		return "admin/index";
	}
	
	//Crear Producto
		@GetMapping("/listAdmin")
		public String list(Model model) {
			List<Producto> productos = productoService.findAll();
			model.addAttribute("productos",productos);
			return "admin/catalogo";
		}
}
