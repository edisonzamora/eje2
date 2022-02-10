package com.libreria.libros.utils;

public class Mensaje {

	public static String setMensaje(String mensaje){
		
		return String.format(FormatoMensaje.FORMATO_LOG_MENSJE, mensaje); 
	}

}
