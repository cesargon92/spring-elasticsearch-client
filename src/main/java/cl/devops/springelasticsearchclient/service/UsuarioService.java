package cl.devops.springelasticsearchclient.service;

import cl.devops.springelasticsearchclient.model.Usuario;
import cl.devops.springelasticsearchclient.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    private static final String USUARIO_INDEX = "usuario-index";

    // Método para agregar usuario al índice usuario de elasticsearch
    public void crearIndexUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    //Método para agregar lista de usuarios al índice usuario de elasticsearch
    public void crearIndexListaUsuarios(List<Usuario> usuarios){
        usuarioRepository.saveAll(usuarios);
    }

    public List<Usuario> buscarPorCantDeporte(Double cantDeporte){
        List<Usuario> usuarios = new ArrayList<>();

        Criteria criteria = new Criteria("cantidadVeces").is(cantDeporte);
        Query query = new CriteriaQuery(criteria);
        SearchHits<Usuario> usuarioSearchHit = elasticsearchOperations
                .search(query, Usuario.class, IndexCoordinates.of(USUARIO_INDEX));
        usuarioSearchHit.forEach(searchHit ->
            usuarios.add(searchHit.getContent())
        );

        return usuarios;
    }

    public List<Usuario> buscarPorCantDeporteEdad(Double cantDeporte, int edad){
        List<Usuario> usuarios = new ArrayList<>();

        Criteria criteria = new Criteria("cantidadVeces")
                .greaterThan(cantDeporte)
                .and(new Criteria("edad").greaterThan(edad));

        Query query = new CriteriaQuery(criteria);

        SearchHits<Usuario> usuarioSearchHit = elasticsearchOperations
                .search(query, Usuario.class, IndexCoordinates.of(USUARIO_INDEX));
        usuarioSearchHit.forEach(searchHit ->
                usuarios.add(searchHit.getContent())
        );

        return usuarios;
    }

    public List<Usuario> buscarPorCantDeporteGenero(Double cantDeporte, String genero){
        List<Usuario> usuarios = new ArrayList<>();

        Criteria criteria = new Criteria("cantidadVeces")
                .greaterThan(cantDeporte)
                .and(new Criteria("genero").is(genero));

        Query query = new CriteriaQuery(criteria);

        SearchHits<Usuario> usuarioSearchHit = elasticsearchOperations
                .search(query, Usuario.class, IndexCoordinates.of(USUARIO_INDEX));
        usuarioSearchHit.forEach(searchHit ->
                usuarios.add(searchHit.getContent())
        );

        return usuarios;
    }
}
