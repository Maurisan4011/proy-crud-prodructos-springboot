package com.maudev.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maudev.springboot.app.models.Producto;
import com.maudev.springboot.app.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	// Metodo POST para crear un nuevo Producto
	// Persisto o Guardo en la BBDD
	@PostMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {

		Producto productoData = productoService.save(producto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Producto Creado
		return ResponseEntity.ok(productoData);

	}

	// Metodo GET para obtener toda la lista de productos
	// existentes en nuestra base de datos
	@GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		// Instancio un nueva lista de Productos
		List<Producto> productos = new ArrayList<Producto>();

		// llamo al servicio creado y obtengo la lista
		productos = productoService.findAll();

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd toda la lista de productos
		return ResponseEntity.ok(productos);
	}

	// Metodo GET para obtener los datos de 1 producto por su ID
	@GetMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> findByIdProducto(@PathVariable String idProducto) {

		// Instancio un nuevo objeto producto
		Producto producto = new Producto();

		// llamo al servicio creado y le paso por parametro el idProducto
		producto = productoService.IdProducto(idProducto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Producto solicitado
		return ResponseEntity.ok(producto);
	}

	// Metodo PUT para modificar un producto existente
	// Persisto y actualizo en la BBDD
	@PutMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {

		// llamo al servicio creado y le paso los nuevos datos
		// NO TENGO QUE MODIFICAR EL ID, tiene que ser el mismo
		Producto productoData = productoService.save(producto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Producto actualizado
		return ResponseEntity.ok(productoData);

	}

	// Metodo DELETE para eliminar los datos de 1 producto por su ID
	@DeleteMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> deleteFindByIdProducto(@PathVariable String idProducto) {

		// Instancio un nuevo objeto producto
		Producto producto = new Producto();

		// llamor al servicio creado y le paso por parametro el idProducto
		producto = productoService.deleteById(idProducto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// Elimino todos los datos del Producto solicitado
		return ResponseEntity.ok(producto);
	}

}
