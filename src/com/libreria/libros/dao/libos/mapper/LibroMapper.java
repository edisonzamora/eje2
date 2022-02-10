package com.libreria.libros.dao.libos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elelemtos.libro2.Libro;


public class LibroMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet arg0, int arg1) throws SQLException {
		Libro libro=new Libro();
		libro.setId(Integer.toString(arg0.getInt("id")));
		libro.setNombre(arg0.getString("nombre"));
		libro.setAutor(arg0.getString("autor"));
		libro.setCodigo(arg0.getString("codigo"));
		return libro;
	}

}
