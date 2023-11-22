package com.app.web.springbootlicfav.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codRol;

    private String descRol;
}
