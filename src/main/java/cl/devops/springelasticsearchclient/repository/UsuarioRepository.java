package cl.devops.springelasticsearchclient.repository;

import cl.devops.springelasticsearchclient.model.Usuario;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UsuarioRepository extends ElasticsearchRepository<Usuario, String> {

}
