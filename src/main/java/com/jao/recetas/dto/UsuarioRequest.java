package com.jao.recetas.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter @Setter @NoArgsConstructor
public class UsuarioRequest {

    private String usuario;
    private String password;
    private boolean activo;
    private Date fechaAlta;

    public UsuarioRequest(String usuario, String password) {

        this.usuario = usuario;
        this.password = password;
        this.activo=true;
        this.fechaAlta=new Date();
    }
}
