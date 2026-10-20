package com.jao.recetas.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class NavegacionRequest {
    private Integer id;
    private String usuario;
    private String controller;
    private String accion;
    private Date fechaAlta;
    public NavegacionRequest( String usuario, String controller, String accion) {
        this.usuario = usuario;
        this.controller = controller;
        this.accion = accion;
        this.fechaAlta = new Date();
    }
}
