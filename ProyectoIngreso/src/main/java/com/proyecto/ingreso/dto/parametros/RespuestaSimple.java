/**
 * 
 */
package com.proyecto.ingreso.dto.parametros;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 * Esta clase permite retornar al cliente de los servicios el resultado del servicio.
 */

@Getter
@Setter
public class RespuestaSimple<T> {
	private Integer codigo;
    private String mensaje;
    private T objeto;
    
    public RespuestaSimple() {
    	
    }

    /**
     * Constructor
     */
    public RespuestaSimple(Integer codigo, String mensaje, T objeto) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

}
