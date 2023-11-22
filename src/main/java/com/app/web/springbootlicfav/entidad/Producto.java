package com.app.web.springbootlicfav.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPro;

    private String descPro;
    private Integer stckPro;
    private Double prePro;
    private Boolean estPro;
    private String foto;

    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "codPro")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "codCat")
    private Categoria categoria;
}
