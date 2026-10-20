package com.jao.recetas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class NavegacionResponse {
    private Integer id;
    private String usuario;
    private String controller;
    private String accion;
    private Date fechaAlta;
    public NavegacionResponse(Integer id, String usuario, String controller, String accion, Date fechaAlta) {
        this.id = id;
        this.usuario = usuario;
        this.controller = controller;
        this.accion = accion;
        this.fechaAlta = fechaAlta;
    }
}
