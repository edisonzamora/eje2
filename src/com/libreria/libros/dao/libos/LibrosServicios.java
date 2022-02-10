package com.libreria.libros.dao.libos;

import java.util.List;

import com.elelemtos.libro2.Libro;

public interface LibrosServicios {

	public Libro buscarPorId(String id);
	
	public Libro buscarPorCodigo(String codigo);
	
	public String agregarLibro(Libro libro);
		
	public Libro[] todosLosLibros();
}
