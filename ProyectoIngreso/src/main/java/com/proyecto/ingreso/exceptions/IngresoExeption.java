package com.proyecto.ingreso.exceptions;

/**
 * En esta clase se gestionan las excepciones del proyecto a nivel de back-end.
 * @author ALFONSO
 *
 */
public class IngresoExeption extends Exception{

	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = -904345503944826518L;

	/**
	 * Constructor de la clase.
	 */
	public IngresoExeption(String mensaje) {
		super(mensaje);
	}

}
