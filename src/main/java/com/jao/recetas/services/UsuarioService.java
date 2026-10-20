package com.jao.recetas.services;

import com.jao.recetas.dto.UsuarioRequest;
import com.jao.recetas.dto.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse create (UsuarioRequest request);
}
