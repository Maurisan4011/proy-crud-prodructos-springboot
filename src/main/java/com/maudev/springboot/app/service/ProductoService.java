package com.maudev.springboot.app.service;

import java.util.List;

import com.maudev.springboot.app.models.Producto;

public interface ProductoService {

	// metodo interrface para poder utilizar tanto en Service implementacion
	// Como tambien en el Controller
	public abstract Producto IdProducto(String idProducto);

	// Guarda un producto
	public abstract Producto save(Producto entity);

	// Obtiene Toda la Lista de productos existente en la base de datos
	public abstract List<Producto> findAll();

	// Modifica los datos de 1 usuario
	public abstract Producto update(Producto entity);
	
	//Elilmino 1 Producto 
	public abstract Producto deleteById(String idProducto);
}
