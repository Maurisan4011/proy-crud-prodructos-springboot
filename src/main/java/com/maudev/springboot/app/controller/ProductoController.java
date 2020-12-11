package com.maudev.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maudev.springboot.app.models.Producto;
import com.maudev.springboot.app.services.IProductoService;

@RestController
@CrossOrigin
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping(value = "/producto/{idProducto}")
	public ResponseEntity<Producto> findByProducto(@PathVariable String idProducto) {

		Producto producto = new Producto();

		producto = productoService.IdProducto(idProducto);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);

	}

}
