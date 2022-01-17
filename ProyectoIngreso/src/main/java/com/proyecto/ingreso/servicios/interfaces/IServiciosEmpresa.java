/**
 * 
 */
package com.proyecto.ingreso.servicios.interfaces;

import java.util.List;

import com.proyecto.ingreso.dto.EmpresaDTO;
import com.proyecto.ingreso.entities.Empresa;
import com.proyecto.ingreso.exceptions.IngresoExeption;

/**
 * @author ALFONSO
 *
 */
public interface IServiciosEmpresa {
	
	/**
	 * Crea la entidad {@link Empresa} en la base de datos.
	 * @param empresa Empresa que se va a crear.
	 * @return {@link EmpresaDTO}
	 * @throws IngresoExeption Se genera por un error al insertar el registro en la base de datos.
	 */
	public EmpresaDTO crearEmpresa(EmpresaDTO empresa) throws IngresoExeption;
	
	/**
	 * Modifica la entidad {@link Empresa} en la base de datos.
	 * @param empresa Empresa que se va a modificar.
	 * @return {@link EmpresaDTO}
	 * @throws IngresoExeption Se genera por un error al modificar el registro en la base de datos.
	 */
	public EmpresaDTO modificarEmpresa(EmpresaDTO empresa) throws IngresoExeption;
	
	/**
	 * Elimina la entidad {@link Empresa} de la base de datos.
	 * @param idEmpresa Id de le empresa que se va a eliminar de la base de datos.
	 * @return true si la operación fue ejecutada con exito.
	 * @throws IngresoExeption Se genera por un error en la eliminación del registro en la base de datos.
	 */
	public boolean eliminarEmpresa(Integer idEmpresa) throws IngresoExeption;
	
	/**
	 * Cosulta una empresa por el código.
	 * @param codigo Código de la empresa que se va a consultar.
	 * @return {@link Empresa}
	 * @throws IngresoExeption Se genera por un error en la consulta.
	 */
	public EmpresaDTO findEmpresaByCodigo(String codigo) throws IngresoExeption;
	
	/**
	 * Cosulta una empresa por el nit.
	 * @param nit Nit de la empresa que se va a consultar.
	 * @return {@link Empresa}
	 * @throws IngresoExeption Se genera por un error en la consulta.
	 */
	public EmpresaDTO findEmpresaByNit(String nit) throws IngresoExeption;
	
	/**
	 * Retorna una lista de las empresas que están registrada en la base de datos.
	 * @return Lista de {@link Empresa}
	 * @throws IngresoExeption Se genera por un error en la consulta.
	 */
	public List<EmpresaDTO> listarEmpresas() throws IngresoExeption;
}
