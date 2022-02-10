package com.libreria.libros.dao.libos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elelemtos.libro2.Libro;
import com.libreria.libros.dao.comun.DaoComun;
import com.libreria.libros.dao.libos.mapper.LibroMapper;
import com.libreria.libros.utils.Mensaje;

public class LibroDao extends DaoComun {
	private Logger logger = LogManager.getLogger(this);

	public LibroDao() {
		// TODO Auto-generated constructor stub
	}

	private String select_from_libros = "SELECT id, nombre, autor, codigo FROM test.libros ";
	private String insert = "INSERT INTO test.libros ";

	public Libro getFineById(String Id) {
		logger.info(Mensaje.setMensaje("getFineById DAO"));
		select_from_libros += "WHERE id=:id";
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", Id);
		LibroMapper libroMapper = new LibroMapper();
		logger.info(Mensaje.setMensaje("query: " + select_from_libros));
		List<Libro> resul = getNamedParameterJdbcTemplate().query(select_from_libros, param, libroMapper);
		logger.info(Mensaje.setMensaje("libro x id encotrados: " + resul.size()));
		if (resul.size() == 1) {
			Libro libroResponse = resul.get(0);
			return libroResponse;
		}
		logger.info(Mensaje.setMensaje("libro x id No encontrado"));
		return null;
	}

	public boolean addLibro(Libro libro) {
		logger.info(Mensaje.setMensaje("addLibro DAO"));
		// INSERT INTO test.libros (nombre, autor, codigo) VALUES (:nombre,
		// :autor,:codigo)
		insert += "(nombre, autor, codigo) VALUES (:nombre, :autor, :codigo)";
		Map<String, String> param = new HashMap<String, String>();
		param.put("nombre", libro.getNombre());
		param.put("autor", libro.getAutor());
		param.put("codigo", libro.getCodigo());
		logger.info(Mensaje.setMensaje("query: " + insert));
		int response_confimation = getNamedParameterJdbcTemplate().update(insert, param);
		if (response_confimation == 1) {
			logger.info(Mensaje.setMensaje("Libro registrado"));
			return true;
		}
		logger.info(Mensaje.setMensaje("Libro no registrado"));
		return false;

	}

	/**
	 * 
	 * @param codigo
	 * @return {@link Libro}
	 * @author Edison Zamora
	 */
	// retorna null si no encuentra libros o hay un error de conección
	public Libro getFineByCodigo(String codigo) {
		logger.info(Mensaje.setMensaje("getFineByCodigo DAO"));
		select_from_libros += "WHERE codigo=:codigo";
		logger.info(Mensaje.setMensaje("query: " + select_from_libros));
		Map<String, String> param = new HashMap<String, String>();
		param.put("codigo", codigo);
		LibroMapper libroMapper = new LibroMapper();
		List<Libro> resul = getNamedParameterJdbcTemplate().query(select_from_libros, param, libroMapper);
		logger.info(Mensaje.setMensaje("libro x codigo encotrados: " + resul.size()));
		if (resul.size() == 1) {
			Libro libroResponse = resul.get(0);
			return libroResponse;
		}
		logger.info(Mensaje.setMensaje("libro x codigo no encontrado"));
		return null;
	}
	
	public List<Libro> getAllLibros(){
		Map<String, String> param = new HashMap<String, String>();
		LibroMapper libroMapper = new LibroMapper();
		List<Libro> resul = getNamedParameterJdbcTemplate().query(select_from_libros, param, libroMapper);
		if (resul.size() >= 1) {
			logger.info(Mensaje.setMensaje("mas de 1 elemento"));
			return resul;
		}
		return null;
	}
}
