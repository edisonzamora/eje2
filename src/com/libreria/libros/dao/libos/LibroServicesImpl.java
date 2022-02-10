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
	public String agregarLibro(Libro libro) {
		logger.info(Mensaje.setMensaje("servicio agregarLibro"));
		String mensaje = "REVISE LOS DATOS , FALTA ALGUNO ";

		if (!libro.getAutor().equalsIgnoreCase("")
				|| libro.getAutor() != null && !libro.getNombre().equalsIgnoreCase("") || libro.getNombre() != null) {
			logger.info("con autor y nombre");
			// asigamnos al libro un codigo aleatorio
			libro.setCodigo(generateCode());
			// buscamos x codigo
			String codigo = libro.getCodigo();
			if (false == existeCodigo(codigo)) {
				logger.info("vamos a registrarlo");

				if (libroDao.addLibro(libro)) {
					mensaje = "REGISTRADO CORRECTAMENTE";
					return mensaje;
				}
			}
		}

		return mensaje;
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

	private boolean existeCodigo(String codigo) {
		logger.info("existeCodigo ?");
		if (null != buscarPorCodigo(codigo)) {
			logger.info("existe");
			return true;
		}
		logger.info("No existe");
		return false;
	}

	@Override
	public Libro[] todosLosLibros() {
		logger.info(Mensaje.setMensaje("servicio todosLosLibros"));
		List<Libro> libros = libroDao.getAllLibros();
		return listToArray(libros);
	}
	private Libro [] listToArray(List<Libro> lista ){
		Libro[] elements = new Libro [lista.size()];
    	for (int i=0 ;i <lista.size(); i++) {
    		elements[i]= lista.get(i);
		}   
    	return elements;
		
	}

}
