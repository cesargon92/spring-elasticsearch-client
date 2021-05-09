package cl.devops.springelasticsearchclient.util;

import cl.devops.springelasticsearchclient.model.Usuario;

import java.util.List;

public class PromedioEdadUtil {

    public static Double CalcularPromedioEdad(List<Usuario> usuarioList){
        if (usuarioList.size() > 0){
            Double suma = usuarioList.stream().mapToDouble(Usuario::getEdad).sum();
            int cont = usuarioList.size();

            return suma / cont;
        } else {
            return null;
        }
    }
}
