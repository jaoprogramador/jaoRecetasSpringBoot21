package com.jao.recetas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponse {
    private String usuario;
    private String password;
    private boolean activo;
    private Date fechaAlta;

    public UsuarioResponse(String usuario, String password) {

        this.usuario = usuario;
        this.password = password;
        this.activo=true;
        this.fechaAlta=new Date();
    }
}
