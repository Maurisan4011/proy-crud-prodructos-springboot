package com.maudev.springboot.app.services;

import com.maudev.springboot.app.models.Producto;


public interface IProductoService {

	//metodo interrface para poder utilizar tanto en Service implementacion
	//Como tambien en el Controller
	public abstract Producto IdProducto(String idProducto);
}
