package com.app.web.springbootlicfav.entidad;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codUsua;

    private String nomUsua;
    private String apeUsua;

    @Column(unique = true, nullable = false)
    private String userUsua;

    private String claUsua;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fnaUsua;

    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "codRol")
    private Rol rol;

    @Column(columnDefinition = "Boolean default true")
    private Boolean est_Usua;

}
