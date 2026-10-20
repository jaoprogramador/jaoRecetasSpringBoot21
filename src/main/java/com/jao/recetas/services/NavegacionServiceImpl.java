package com.jao.recetas.services;

import com.jao.recetas.dto.NavegacionRequest;
import com.jao.recetas.dto.NavegacionResponse;
import com.jao.recetas.model.Navegacion;
import com.jao.recetas.repository.NavegacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class NavegacionServiceImpl implements NavegacionService{

    private final NavegacionRepository navegacionRepository;

    @Override
    @Transactional
    public NavegacionResponse create(NavegacionRequest request) {

        Navegacion navegacion = new Navegacion(request.getUsuario(), request.getController(), request.getAccion());
        Navegacion navegacionNuevo = this.navegacionRepository.save(navegacion);

        return new NavegacionResponse(navegacionNuevo.getId(),navegacionNuevo.getUsuario(), navegacionNuevo.getController(), navegacionNuevo.getAccion(), new Date());
    }

    @Override
    @Transactional
    public void createException(NavegacionRequest request) {

        Navegacion navegacion = new Navegacion(request.getUsuario(), request.getController(), request.getAccion());
        Navegacion navegacionNuevo = this.navegacionRepository.save(navegacion);
        throw new RuntimeException();

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createExceptionNew(NavegacionRequest request) {

        Navegacion navegacion = new Navegacion(request.getUsuario(), request.getController(), request.getAccion());
        Navegacion navegacionNuevo = this.navegacionRepository.save(navegacion);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createExceptionNewIO(NavegacionRequest request) throws IOException {

        Navegacion navegacion = new Navegacion(request.getUsuario()+"COPIA", request.getController(), request.getAccion());
        Navegacion navegacionNuevo = this.navegacionRepository.save(navegacion);
        throw new IOException();


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {IOException.class})
    public void createExceptionNewIOException(NavegacionRequest request) throws IOException {

        Navegacion navegacion = new Navegacion(request.getUsuario()+"COPIA", request.getController(), request.getAccion());
        Navegacion navegacionNuevo = this.navegacionRepository.save(navegacion);
        throw new IOException();


    }
}
