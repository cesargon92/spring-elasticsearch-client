package cl.devops.springelasticsearchclient.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestDto {
    private String nombreUsuario;
    private int edad;
    private String genero;
    private Double cantidadVeces;
    private boolean tieneTrabajo;
}
