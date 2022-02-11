/**
 * LibrosSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.libreria.libros;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elelemtos.libro2.AddResponse;
import com.elelemtos.libro2.CodigolibroResponse;
import com.elelemtos.libro2.IdlibroResponse;
import com.elelemtos.libro2.Libro;
import com.elelemtos.libro2.LibrosResponse;
import com.elelemtos.libro2.ListaLibros;
import com.libreria.libros.dao.libos.LibroServicesImpl;
import com.libreria.libros.dao.libos.LibrosServicios;
import com.libreria.libros.utils.Mensaje;

/**
 * LibrosSkeleton java skeleton for the axisService
 */
public class LibrosSkeleton {
	private Logger logger = LogManager.getLogger(this);
	private LibroServicesImpl servicioLib = new LibroServicesImpl();

	/**
	 * Auto generated method signature
	 *
	 * @param librosRequest
	 * @return librosResponse
	 */
	public com.elelemtos.libro2.LibrosResponse listaLibrosO(com.elelemtos.libro2.LibrosRequest librosRequest) {
		// TODO : fill this with the necessary business logic
		logger.info(Mensaje.setMensaje("listaLibrosO service in"));
		LibrosResponse librosResponse = new LibrosResponse();
		ListaLibros lista = new ListaLibros();
		// llamamos al servicio get Todos los libros
		Libro[] listadb = servicioLib.todosLosLibros();
		logger.info(Mensaje.setMensaje("listaLibrosO service Out"));
		// agregamos la lista a el objeto que contendra la lista
		lista.setLibros(listadb);
		// llenamosla respuesta
		librosResponse.setLibrosResponse(lista);

		return librosResponse;
	}

	/**
	 * Auto generated method signature
	 *
	 * @param idlibroRequest
	 * @return idlibroResponse
	 */
	public com.elelemtos.libro2.IdlibroResponse buscarLibroPorIdO(com.elelemtos.libro2.IdlibroRequest idlibroRequest) {
		logger.info(Mensaje.setMensaje("buscarLibroPorIdO service in"));
		IdlibroResponse libroResponse = new IdlibroResponse();
		String id = idlibroRequest.getId();
		Libro libro = servicioLib.buscarPorId(id);
		libroResponse.setIdlibroResponse(libro);
		logger.info(Mensaje.setMensaje("buscarLibroPorIdO service out"));
		return libroResponse;
	}

	/**
	 * Auto generated method signature
	 *
	 * @param codigolibroRequest
	 * @return codigolibroResponse
	 */
	public com.elelemtos.libro2.CodigolibroResponse buscarLibroPorCodigoO(
			com.elelemtos.libro2.CodigolibroRequest codigolibroRequest) {
		logger.info(Mensaje.setMensaje("buscarLibroPorCodigoO service in"));
		CodigolibroResponse libroResponse = new CodigolibroResponse();
		String codigo = codigolibroRequest.getCodigo();
		Libro libro = servicioLib.buscarPorCodigo(codigo);
		libroResponse.setCodigolibroResponse(libro);
		logger.info(Mensaje.setMensaje("buscarLibroPorCodigoO service out"));
		return libroResponse;
	}

	/**
	 * Auto generated method signature
	 *
	 * @param addRequest
	 * @return addResponse
	 */
	public com.elelemtos.libro2.AddResponse addLibroO(com.elelemtos.libro2.AddRequest addRequest) {
		logger.info(Mensaje.setMensaje("addLibroO service in"));
		AddResponse libroResponse = new AddResponse();
		ListaLibros lista = new ListaLibros();
		Libro libroRequest = addRequest.getAddRequest();
		Libro[] listadb = servicioLib.agregarLibro(libroRequest.getId(), libroRequest.getCodigo(),
				libroRequest.getNombre(), libroRequest.getAutor());
		// si el servicio no devuelve un arry lleno lo devolvenos
		if (null != listadb) {
			lista.setLibros(listadb);
			libroResponse.setAddResponse(lista);
			logger.info(Mensaje.setMensaje("addLibroO service out"));
			return libroResponse;
		}
		logger.info(Mensaje.setMensaje("lista vacia"));
		// si esta vacio , lo iniciamos y lo retormamos 
		listadb = new Libro[1];
		lista.setLibros(listadb);
		libroResponse.setAddResponse(lista);
		logger.info(Mensaje.setMensaje("addLibroO service out"));
		return libroResponse;

	}

}
