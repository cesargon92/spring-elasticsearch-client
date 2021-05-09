package cl.devops.springelasticsearchclient.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "usuario-index")
public class Usuario {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "nombreUsuario")
    private String nombreUsuario;

    @Field(type = FieldType.Integer, name = "edad")
    private int edad;

    @Field(type = FieldType.Text, name = "genero")
    private String genero;

    @Field(type = FieldType.Double, name = "cantidadVeces")
    private Double cantidadVeces;

    @Field(type = FieldType.Boolean, name = "tieneTrabajo")
    private boolean tieneTrabajo;
}
