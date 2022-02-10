package com.libreria.libros.dao.comun;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.libreria.libros.utils.Mensaje;






public class DaoComun extends CrudDaoImp {

	private  DriverManagerDataSource dc;
	private  NamedParameterJdbcTemplate npjt;
	private Logger logger = LogManager.getLogger(this);
//	static {
//		logger.debug(">>>>>>>>>>>>dataSource");
//		dc = new DriverManagerDataSource();
//		dc.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
//		dc.setUsername("admin");
//		dc.setPassword("admin");
//		npjt =new NamedParameterJdbcTemplate(dc);
//	}

	@Override
	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		logger.info(Mensaje.setMensaje("getNamedParameterJdbcTemplate"));
		dc = new DriverManagerDataSource();
		dc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
		dc.setUsername("admin");
		dc.setPassword("admin");
		npjt =new NamedParameterJdbcTemplate(dc);
		return npjt;
	}

}
