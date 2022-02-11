package com.libreria.libros.dao.libos;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elelemtos.libro2.Libro;
import com.libreria.libros.utils.Mensaje;

public class LibroServicesImpl implements LibrosServicios {

	LibroDao libroDao = new LibroDao();

	public LibroServicesImpl() {

	}

	private Logger logger = LogManager.getLogger(this);

	@Override
	public Libro buscarPorId(String id) {
		logger.info(Mensaje.setMensaje("servicio buscarPorId"));
		Libro libro = libroDao.getFineById(id);
		return libro;
	}

	@Override
	public boolean agregarLibro(Libro libro) {
		return agregar(libro);
	}

	public Libro[] agregarLibro(String id, String codigo, String nombre, String autor) {
		Libro libroadd = new Libro();
		libroadd.setId(id);
		libroadd.setCodigo(codigo);
		libroadd.setNombre(nombre);
		libroadd.setAutor(autor);
		if (agregar(libroadd)) {
			return todosLosLibros();
		}
		return null;
	}

	private boolean agregar(Libro libro) {
		logger.info(Mensaje.setMensaje("servicio agregarLibro"));
		// buscamos x id si existe, verificamos que el id no esta vacio
		
		if (!libro.getId().equals("")) {
			if (buscarPorId(libro.getId()) != null) {
				logger.info(Mensaje.setMensaje("escontrado x id"));
				return false;
			}
			logger.info(Mensaje.setMensaje("no escontrado x id"));
		}
		// setiamos el id--- ya que generara autoamaticamente en bd
		logger.info(Mensaje.setMensaje("setiamos ID"));
		
		// buscamos x codigo si existe, verificamos que el codigo no esta vacio
		// si codigo no esta espesificado, le asignamos uno.
		logger.info(Mensaje.setMensaje("buscamos x codigo"));
		if(libro.getCodigo()==null){
			logger.info(Mensaje.setMensaje("codigo null"));
			libro.setCodigo("");
		}
		if (!libro.getCodigo().equalsIgnoreCase("")) {
			logger.info(Mensaje.setMensaje("codigo:" + libro.getCodigo()));
			if (buscarPorCodigo(libro.getCodigo()) != null) {
				logger.info(Mensaje.setMensaje("escontrado x codigo"));
				return false;
			}
		} else {
			// codigo vacio añadimos alearotiaente y buscamos x codigo 
			logger.info(Mensaje.setMensaje("codigo no espesificado añadios aleatorio"));
			libro.setCodigo(generateCode());
			if (buscarPorCodigo(libro.getCodigo()) != null) {
				logger.info(Mensaje.setMensaje("escontrado x codigo"));
				return false;
			}
		}
		// verifocamos obligatorio el nombre del libro
		if (libro.getNombre().equalsIgnoreCase("")) {
			logger.info(Mensaje.setMensaje("falta el nombre"));
			return false;
		}
		// agregamos el libro
		libro.setId("");
		if (libroDao.addLibro(libro)) {
			logger.info(Mensaje.setMensaje("agregado corectamente"));
			return true;
		}
		logger.info(Mensaje.setMensaje(" no se a podido agregar"));
		return false;
	}

	private String generateCode() {
		String code = UUID.randomUUID().toString();
		return code;
	}

	@Override
	public Libro buscarPorCodigo(String codigo) {
		logger.info(Mensaje.setMensaje("servicio buscarPorCodigo"));
		Libro libroencontrado = libroDao.getFineByCodigo(codigo);
		return libroencontrado;
	}

	public Libro buscarPorCodigo(Libro libro) {
		Libro libroencontrado = buscarPorCodigo(libro.getCodigo());
		return libroencontrado;
	}

	@Override
	public Libro[] todosLosLibros() {
		logger.info(Mensaje.setMensaje("servicio todosLosLibros"));
		List<Libro> libros = libroDao.getAllLibros();
		return listToArray(libros);
	}

	private Libro[] listToArray(List<Libro> lista) {
		Libro[] elements = new Libro[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			elements[i] = lista.get(i);
		}
		return elements;

	}

}
