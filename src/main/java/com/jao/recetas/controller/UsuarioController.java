package com.jao.recetas.controller;

import com.jao.recetas.dto.UsuarioRequest;
import com.jao.recetas.dto.UsuarioResponse;
import com.jao.recetas.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest request){
        String log = request.getUsuario() +" "+ request.getPassword();
        System.out.println("UsuarioServiceImpl::"+log);
        return ResponseEntity.ok(this.usuarioService.create(request));
    }

}
