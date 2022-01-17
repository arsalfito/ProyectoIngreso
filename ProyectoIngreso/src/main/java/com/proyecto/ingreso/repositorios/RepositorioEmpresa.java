/**
 * 
 */
package com.proyecto.ingreso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.ingreso.entities.Empresa;


/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {

	public Empresa findByCodigo(@Param("codigo") String codigo);
	public Empresa findByNit(@Param("nit") String nit);
}
