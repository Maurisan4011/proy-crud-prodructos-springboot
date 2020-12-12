package com.maudev.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maudev.springboot.app.models.Producto;
import com.maudev.springboot.app.services.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	// Metodo GET para obtener los datos de 1 producto por su ID
	@GetMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> findByProducto(@PathVariable String idProducto) {
		
		// Instancio un nuevo objeto producto
		Producto producto = new Producto();

		// llamor al servicio creado  y le paso por parametro el idProducto
		producto = productoService.IdProducto(idProducto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Producto solicitado
		return ResponseEntity.ok(producto);
	}

}
