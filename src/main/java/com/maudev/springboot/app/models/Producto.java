package com.maudev.springboot.app.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1731902390885211826L;

	@Id
	@MongoId(value = FieldType.OBJECT_ID)
	private String id;

	private String nombre;

	private String descripcion;

	private String marca;

	private Double precio;

	private Integer cantidad;

	private String rubro;

}
