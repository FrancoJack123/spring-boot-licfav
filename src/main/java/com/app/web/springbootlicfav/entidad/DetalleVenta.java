package com.app.web.springbootlicfav.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_detVenta")
@Data
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDetVenta;
    private Integer cantDetVenta;
    private Double preDetVenta;
    private Integer montoDetVenta;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "codPro")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "venta", referencedColumnName = "codVen")
    @JsonBackReference
    private Venta venta;
}
