package com.maudev.springboot.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maudev.springboot.app.models.Producto;
import com.maudev.springboot.app.repository.ProductoRepository;
import com.maudev.springboot.app.services.IProductoService;

@Service("productoService")
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto IdProducto(String idProducto) {

		Producto producto = null;

		try {

			producto = productoRepository.findById(idProducto);

		} catch (Exception e) {

		}

		return producto;

	}

}
