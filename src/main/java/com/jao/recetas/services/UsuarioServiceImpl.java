package com.jao.recetas.services;

import com.jao.recetas.dto.NavegacionRequest;
import com.jao.recetas.dto.UsuarioRequest;
import com.jao.recetas.dto.UsuarioResponse;
import com.jao.recetas.model.Usuario;
import com.jao.recetas.repository.NavegacionRepository;
import com.jao.recetas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    private final NavegacionService navegacionService;

    @Override
    //@Transactional(noRollbackFor = {RuntimeException.class})
    public UsuarioResponse create(UsuarioRequest request) {

        Usuario usuario = new Usuario(request.getUsuario(), request.getPassword());
        Usuario usuarioNuevo = this.usuarioRepository.save(usuario);

        try {
            navegacionService.create(new NavegacionRequest( usuario.getUsuario(), "UsuarioServiceImpl", "POST USUARIO" ));

            navegacionService.createException(new NavegacionRequest( usuario.getUsuario()+"CPOPIA", "UsuarioServiceImpl", "POST USUARIO" ));

            navegacionService.createExceptionNew(new NavegacionRequest( usuario.getUsuario()+"CPOPIANEW", "UsuarioServiceImpl", "POST USUARIO" ));

            navegacionService.createExceptionNewIO(new NavegacionRequest( usuario.getUsuario()+"CPOPIANEWIO", "UsuarioServiceImpl", "POST USUARIO" ));

            navegacionService.createExceptionNewIOException(new NavegacionRequest( usuario.getUsuario()+"CPOPIANEWIOEXC", "UsuarioServiceImpl", "POST USUARIO" ));

        } catch (Exception e) {
            log.error("UsuarioResponse:::Excepcion capturada");
        }
        return new UsuarioResponse(usuario.getUsuario(),usuario.getPassword());
    }
}
