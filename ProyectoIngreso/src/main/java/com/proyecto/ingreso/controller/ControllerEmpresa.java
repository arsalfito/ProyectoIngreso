/**
 * 
 */
package com.proyecto.ingreso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ingreso.dto.EmpresaDTO;
import com.proyecto.ingreso.dto.parametros.RespuestaConLista;
import com.proyecto.ingreso.dto.parametros.RespuestaSimple;
import com.proyecto.ingreso.exceptions.IngresoExeption;
import com.proyecto.ingreso.servicios.interfaces.IServiciosEmpresa;

/**
 * @author ALFONSO
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/")
public class ControllerEmpresa {
	
	//--------------------------------
	//Atributos de la clase.
	//--------------------------------
	
	/**
	 * Implementa los servicios de negocio para la gestión de la información de las empresas.
	 */
	@Autowired
	private IServiciosEmpresa serviciosEmpresa;
	
	//--------------------------------
	//Servicios.
	//--------------------------------
	
	/**
	 * Crear una empresa en la base de datos.
	 * @param body Datos de la empresa.
	 * @return La empresa creado junto con los mesajes de creación o de error que se presente.
	 */
	@PostMapping(path = "/empresa/crearEmpresa", consumes =  MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaSimple<EmpresaDTO>> crearEmpresa(@RequestBody EmpresaDTO body){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
					new RespuestaSimple<EmpresaDTO>(0,"La empresa fue creada satisfactoriamente.",this.serviciosEmpresa.crearEmpresa(body)));
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaSimple<EmpresaDTO>(-1, e.getMessage(), null));
		}
		
	}
	
	/**
	 * Modificar una empresa en la base de datos.
	 * @param body datos de la empresa a modificar
	 * @return La empresa modificada junto con los mesajes de modificaciòn o de error que se presente.
	 */
	@PostMapping(path = "/empresa/modificarEmpresa", consumes =  MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaSimple<EmpresaDTO>> modificarEmpresa(@RequestBody EmpresaDTO body){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
					new RespuestaSimple<EmpresaDTO>(0,"La empresa fue modificada satisfactoriamente",this.serviciosEmpresa.modificarEmpresa(body)) );
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaSimple<EmpresaDTO>(-1, e.getMessage(), null));
		}
	}
	
	/**
	 * Borra una empresa de la base de datos.
	 * @param idEmpresa Id de la empresa que se desea borrar.
	 * @return El mensaje de respuesta junto con el resultado de la operaciòn de borrado.
	 */
	@PostMapping(path = "/empresa/eliminarEmpresa", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaSimple<Boolean>> eliminarEmpresa(@RequestParam("idEmpresa") Integer idEmpresa){
		try {
			this.serviciosEmpresa.eliminarEmpresa(idEmpresa);
			return ResponseEntity.status(HttpStatus.OK).body(new RespuestaSimple<Boolean>(0,"La empresa fue eliminada satisfactoriamente.", true));
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaSimple<Boolean>(-1, e.getMessage(), false));
		}
	}
	
	/**
	 * Consulta una empresa por el codigo.
	 * @param codigo Codigo de la empresa que se va a consultar.
	 * @return La empresa junto con los mensajes de consulta o de error que se puedan presentar.
	 */
	@GetMapping(path = "/empresa/findEmpresaByCodigo", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaSimple<EmpresaDTO>> findEmpresaByCodigo(@RequestParam("codigo") String codigo){
		try {
			EmpresaDTO result = this.serviciosEmpresa.findEmpresaByCodigo(codigo);			
			return ResponseEntity.status(HttpStatus.OK).body(new RespuestaSimple<EmpresaDTO>(0, (result != null ? "La empresa fue encontrada." : "La empresa no esta registrada."), result));
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaSimple<EmpresaDTO>(-1, e.getMessage(), null));
		}
	}
	
	/**
	 * Consulta una empresa por el Nit.
	 * @param nit Nit de la empresa que se desea consultar.
	 * @return La empresa junto con los mensajes de consulta o de error que se puedan presentar.
	 */
	@GetMapping(path = "/empresa/findEmpresaByNit", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaSimple<EmpresaDTO>> findEmpresaByNit(@RequestParam("nit") String nit){
		try {
			EmpresaDTO result = this.serviciosEmpresa.findEmpresaByNit(nit);
			return ResponseEntity.status(HttpStatus.OK).body(new RespuestaSimple<EmpresaDTO>(0,(result != null ? "La empresa fue encontrada." : "La empresa no esta registrada."), result));
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaSimple<EmpresaDTO>(-1, e.getMessage(), null));
		}
	}
	
	/**
	 * Lista de las empresas registradas.
	 * @return Las empresas registradas junto con los mensajes de consulta o de error que se puedan presentar.
	 */
	@GetMapping(path = "/empresa/listarEmpresas", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<RespuestaConLista> listarEmpresas(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new RespuestaConLista(0,"Lista de empresas registradas.", this.serviciosEmpresa.listarEmpresas()));
		} catch (IngresoExeption e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaConLista(-1, e.getMessage(), null));
		}
	}
	
}
