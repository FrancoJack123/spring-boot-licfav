package com.app.web.springbootlicfav.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPro;

    private String nomProv;
    private String telProv;
    private String emailProv;

}
