package com.proyecto.ingreso.dto.parametros;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ALFONSO
 * Esta clase permite retornar al cliente de los servicios el resultado del servicio.
 */

@Getter
@Setter
public class RespuestaConLista {
    private Integer codigo;
    private String mensaje;
    private List<?> lista;
    
    public RespuestaConLista() {
    	
    }

    /**
     * Constructor
     */
    public RespuestaConLista(Integer codigo, String mensaje, List<?> lista) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.lista = lista;
    }

}
