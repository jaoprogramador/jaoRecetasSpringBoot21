package com.jao.recetas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "navegacion")
@Getter
@Setter
@NoArgsConstructor
public class Navegacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true, length = 40)
    private String usuario;
    @Column(nullable = true, length = 40)
    private String controller;
    @Column(nullable = true, length = 40)
    private String accion;
    private Date fechaAlta;
    public Navegacion(Integer id, String usuario, String controller, String accion, Date fechaAlta) {
        this.id = id;
        this.usuario = usuario;
        this.controller = controller;
        this.accion = accion;
        this.fechaAlta = fechaAlta;
    }
    public Navegacion( String usuario, String controller, String accion) {

        this.usuario = usuario;
        this.controller = controller;
        this.accion = accion;
        this.fechaAlta = new Date();
    }



}
