package cl.devops.springelasticsearchclient.controller;

import cl.devops.springelasticsearchclient.dto.RequestDto;
import cl.devops.springelasticsearchclient.dto.ResponseDto;
import cl.devops.springelasticsearchclient.model.Usuario;
import cl.devops.springelasticsearchclient.service.UsuarioService;
import cl.devops.springelasticsearchclient.util.PromedioEdadUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios-rest")
@Log4j2
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("add-user")
    public void agregarUsuario(@RequestBody RequestDto usuarioDto){
        log.info("RequestDto = {}", usuarioDto);
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuarioService.crearIndexUsuario(usuario);
    }

    @PostMapping("add-users")
    public void agregarUsuarios(@RequestBody List<RequestDto> usuarios){
        List<Usuario> usuarioList =
                usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, Usuario.class))
                .collect(Collectors.toList());
        usuarioService.crearIndexListaUsuarios(usuarioList);
    }

    @GetMapping("usuarios")
    public ResponseDto obtenerUsuariosSinDeporte(@RequestParam("cantidadVeces")  Double cantidadVeces){
        return new ResponseDto(
                PromedioEdadUtil.CalcularPromedioEdad(
                        usuarioService.buscarPorCantDeporte(cantidadVeces)));

    }

    @GetMapping("get-usuarios")
    public ResponseDto obtenerUsuariosDeporteEdad(
            @RequestParam("cantidadVecesSobre")  Double cantidadVeces,
            @RequestParam("edadSobre")  int edad){
        return new ResponseDto(
                PromedioEdadUtil.CalcularPromedioEdad(
                        usuarioService.buscarPorCantDeporteEdad(cantidadVeces, edad)));

    }

    @GetMapping("get-usuarios-genero")
    public ResponseDto obtenerUsuariosDeporteGenero(
            @RequestParam("cantidadVecesSobre")  Double cantidadVeces,
            @RequestParam("genero")  String genero){
        return new ResponseDto(
                PromedioEdadUtil.CalcularPromedioEdad(
                        usuarioService.buscarPorCantDeporteGenero(cantidadVeces, genero)));
    }
}
