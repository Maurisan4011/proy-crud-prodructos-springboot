package com.maudev.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maudev.springboot.app.models.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends MongoRepository<Producto, Serializable> {
	// DENTRO DE ESTE BLOQUE DE CODIGO VOY A HACER LAS CONSULTAS
	// QUE NECESITE CONTRA MONGO DB

	// internamente Actua como una Querry de consulta
	// Busca en base de datos un producto por medio del ID
	Producto findById(String id);
	// Elimina en base de datos un producto por medio del ID
	Producto deleteById(String id);

}
