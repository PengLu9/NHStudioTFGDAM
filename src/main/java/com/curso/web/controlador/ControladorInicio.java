package com.curso.web.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.web.modelo.DetallePedido;
import com.curso.web.modelo.Pedido;
import com.curso.web.modelo.Producto;
import com.curso.web.service.ProductoService;
//Controlador de la pagina principal del inicio de usuario comprador
@Controller
@RequestMapping("/")
public class ControladorInicio {

	@Autowired
	private ProductoService productoService;
	
	private final Logger log= LoggerFactory.getLogger(ControladorInicio.class);
	//Almacena los detalles
	Pedido pedido = new Pedido();
	List<DetallePedido> detallesPedido = new ArrayList<DetallePedido>();
	@GetMapping("")
	public String inicio() {
	
		return "usuario/index";
	}
	
	//Crear Producto
			@GetMapping("/listaProducto")
			public String list(Model model) {
				List<Producto> productos = productoService.findAll();
				model.addAttribute("productos",productos);
				return "usuario/catalogo";
			}
			
			//Salta a la pagina de detalle de producto, redirecciona por id
			@GetMapping("/productoDetalle/{id}")
			public String productoDetalle(@PathVariable Integer id, Model model) {
				
				Producto producto = new Producto();
				Optional<Producto> productoOptional = productoService.get(id);
				producto = productoOptional.get();
				model.addAttribute("productos",producto);
				return "usuario/productoDetalle";
			}
			@PostMapping("/carrito")
			public String addCarrito(@RequestParam Integer id, @RequestParam Integer cantidad , Model model) {
				DetallePedido detallepedido = new DetallePedido();
				Producto producto = new Producto();
				double sumaTotalPedido;		
				Optional<Producto> optionalProducto = productoService.get(id);
				
				producto =optionalProducto.get();
				
				detallepedido.setCantidad(cantidad);
				detallepedido.setPrecio(producto.getPrice());
				detallepedido.setNombre(producto.getName());
				detallepedido.setTotal(producto.getPrice()*cantidad);
				detallepedido.setProducto(producto);
				
				detallesPedido.add(detallepedido);

				sumaTotalPedido = detallesPedido.stream().mapToDouble(dt->dt.getTotal()).sum();
				model.addAttribute("carrito",detallesPedido);
				model.addAttribute("pedido",pedido);
				
				return "usuario/carrito";
			}
}
