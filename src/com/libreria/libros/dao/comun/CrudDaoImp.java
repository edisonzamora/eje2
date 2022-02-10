package com.libreria.libros.dao.comun;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public abstract class CrudDaoImp {

	protected abstract NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();
}
