/**
 * 
 */
package com.proyecto.ingreso.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ingreso.dto.EmpresaDTO;
import com.proyecto.ingreso.entities.Empresa;
import com.proyecto.ingreso.exceptions.IngresoExeption;
import com.proyecto.ingreso.fachada.EmpresaFachada;
import com.proyecto.ingreso.repositorios.RepositorioEmpresa;
import com.proyecto.ingreso.servicios.interfaces.IServiciosEmpresa;

/**
 * @author ALFONSO
 *
 */
@Service
public class ServiciosEmpresa implements IServiciosEmpresa {

	@Autowired
	private RepositorioEmpresa repositorioEmpresa; 
	
	/**
	 * crearEmpresa
	 */
	@Override
	public EmpresaDTO crearEmpresa(EmpresaDTO empresa) throws IngresoExeption {
		
		Empresa empresaDB = this.repositorioEmpresa.findByCodigo(empresa.getCodigo());
		if(empresaDB!=null)
			throw new IngresoExeption("Error, la empresa que desea crear ya se encuentra registrada en el sistema.");
		
		return EmpresaFachada.getInstance().convertirDTO(this.repositorioEmpresa.save(
				EmpresaFachada.getInstance().convertirEntity(empresa)));
	}

	/**
	 * modificarEmpresa
	 */
	@Override
	public EmpresaDTO modificarEmpresa(EmpresaDTO empresa) throws IngresoExeption {
		Empresa empresaDB = this.repositorioEmpresa.findById(empresa.getId()).orElse(null);
		if(empresaDB==null)
			throw new IngresoExeption("Error: la empresa que desea modificar no se encuentra en el sistema");
		
		return EmpresaFachada.getInstance().convertirDTO(this.repositorioEmpresa.save(
				EmpresaFachada.getInstance().convertirEntity(empresa)));
	}

	/**
	 * eliminarEmpresa
	 */
	@Override
	public boolean eliminarEmpresa(Integer idEmpresa) throws IngresoExeption {
		Empresa empresaDB = this.repositorioEmpresa.findById(idEmpresa).orElse(null);
		if(empresaDB==null)
			throw new IngresoExeption("Error: la empresa que desea eliminar no se encuentra en el sistema");
		this.repositorioEmpresa.deleteById(idEmpresa);
		return true;
	}

	/**
	 * findEmpresaByCodigo
	 */
	@Override
	public EmpresaDTO findEmpresaByCodigo(String codigo) throws IngresoExeption {
		return EmpresaFachada.getInstance().convertirDTO(this.repositorioEmpresa.findByCodigo(codigo));
	}

	/**
	 * findEmpresaByNit
	 */
	@Override
	public EmpresaDTO findEmpresaByNit(String nit) throws IngresoExeption {
		return EmpresaFachada.getInstance().convertirDTO(this.repositorioEmpresa.findByNit(nit));
	}

	/**
	 * listarEmpresas
	 */
	@Override
	public List<EmpresaDTO> listarEmpresas() throws IngresoExeption {
		return EmpresaFachada.getInstance().obtenerListaDTO(this.repositorioEmpresa.findAll());		
	}

}
