package com.jao.recetas.services;

import com.jao.recetas.dto.NavegacionRequest;
import com.jao.recetas.dto.NavegacionResponse;
import com.jao.recetas.dto.UsuarioRequest;
import com.jao.recetas.dto.UsuarioResponse;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface NavegacionService {
    public NavegacionResponse create(NavegacionRequest request);
    public void createException(NavegacionRequest request);
    public void createExceptionNew(NavegacionRequest request);
    public void createExceptionNewIO(NavegacionRequest request) throws IOException;
    public void createExceptionNewIOException(NavegacionRequest request) throws IOException;
}
