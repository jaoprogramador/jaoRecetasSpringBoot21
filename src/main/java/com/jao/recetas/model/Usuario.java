package com.jao.recetas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true, length = 40)
    private String usuario;
    @Column(nullable = true, length = 40)
    private String password;
    @Column(nullable = false)
    private boolean activo;
    private Date fechaAlta;

    public Usuario( String usuario, String password) {

        this.usuario = usuario;
        this.password = password;
        this.activo=true;
        this.fechaAlta=new Date();
    }
}
