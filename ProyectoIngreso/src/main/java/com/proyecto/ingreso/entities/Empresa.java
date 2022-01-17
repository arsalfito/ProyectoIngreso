/**
 * 
 */
package com.proyecto.ingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EMPRESAS")
@Getter
@Setter
public class Empresa {
	
	//--------------------------------
	//Atributos de la clase.
	//--------------------------------
	
	/**
	 * Id de la empresa.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqEmpresa" )
	@SequenceGenerator( name = "SeqEmpresa", sequenceName = "SEQ_EMPRESAS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_EMPRESA_PK", nullable = false )
	private int id;
	
	/**
	 * Codigo de la empresa.
	 */
	@Column( name = "CODIGO", nullable = false, updatable = true, unique = true )
	private String codigo;
	
	/**
	 * Nit de identificación de la empresa.
	 */
	@Column( name = "NIT", nullable = false, updatable = true, unique = true )
	private String nit;
	
	/**
	 * Nombre de la empresa.
	 */
	@Column( name = "NOMBRE", nullable = false, updatable = true )
	private String nombre;

	
	//--------------------------------
	//Constructor de la clase.
	//--------------------------------

	/**
	 * Constructor por defecto.
	 */
	public Empresa() {}


}
