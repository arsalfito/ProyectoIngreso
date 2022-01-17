/**
 * 
 */
package com.proyecto.ingreso.fachada;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.proyecto.ingreso.dto.EmpresaDTO;
import com.proyecto.ingreso.entities.Empresa;

/**
 * @author ALFONSO
 *	Esta clase premite transformar la entidad Empresa a DTO o de TO a entidad, asi como transforma una lista de entidades o dtos.
 */
public class EmpresaFachada {

	
	private static EmpresaFachada empresaFachada;
	
	
	public static EmpresaFachada getInstance() {
		if(empresaFachada == null)
			return new EmpresaFachada();
		else
			return empresaFachada;
	}
	
	public List<EmpresaDTO> obtenerListaDTO(List<Empresa> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	public List<Empresa> obtenerListaEntity(List<EmpresaDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public EmpresaDTO convertirDTO(Empresa entity){
		
		if (Objects.isNull(entity))
			return null;
		
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setId(entity.getId());
		empresaDTO.setCodigo(entity.getCodigo());
		empresaDTO.setNit(entity.getNit());
		empresaDTO.setNombre(entity.getNombre());
		
		return empresaDTO;
	}
	
	public Empresa convertirEntity(EmpresaDTO dto){
		
		if (Objects.isNull(dto))
			return null;
		
		Empresa  empresa = new Empresa();
		empresa.setId(dto.getId());
		empresa.setCodigo(dto.getCodigo());
		empresa.setNit(dto.getNit());
		empresa.setNombre(dto.getNombre());
		
		return empresa;
	}
	
}
