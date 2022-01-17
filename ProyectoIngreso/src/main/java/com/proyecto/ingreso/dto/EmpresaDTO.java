/**
 * 
 */
package com.proyecto.ingreso.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Getter
@Setter
public class EmpresaDTO {
	
	/**
	 * Id de la empresa.
	 */
	private int id;
	
	/**
	 * Codigo de la empresa.
	 */
	private String codigo;
	
	/**
	 * Nit de identificación de la empresa.
	 */
	private String nit;
	
	/**
	 * Nombre de la empresa.
	 */
	private String nombre;
	

	/**
	 * Constructor por defecto.
	 */
	public EmpresaDTO() {}

}
