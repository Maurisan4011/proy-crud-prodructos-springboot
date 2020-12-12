package com.maudev.springboot.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maudev.springboot.app.models.Producto;
import com.maudev.springboot.app.repository.ProductoRepository;
import com.maudev.springboot.app.services.IProductoService;

@Service("productoService")
public class ProductoServiceImpl implements IProductoService {

	//Inyecto el Repository  
	//Para usar sus funciones e implementar 
	//en la logica de los sevicios
	@Autowired
	private ProductoRepository productoRepository;

	
	//con este contrato o metodo de mi capa actual  
	//creo la logica para poder hacer la consulta con mi base de datos monngo  
	@Override
	public Producto IdProducto(String idProducto) {
		// Instancio un nuevo objeto producto
		Producto producto = null;
 
		//Envolvemos en una validacion 
		//para que en caso falle por algun motivo esa consulta 
		//me imprima en la consola en que parte fallo mi app 
		try {

			producto = productoRepository.findById(idProducto);

		} catch (Exception e) {

		
			e.printStackTrace();
		}

		//En caso de exito devuelvo todos los datos que contiene Producto 
		return producto;

	}

}
