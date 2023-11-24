package com.app.web.springbootlicfav.entidad;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_venta")
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVen;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fchVen;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "codUsua", referencedColumnName = "codUsua")
    private Usuario usuario;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVentaList = new ArrayList<>();

    public Venta() {
    }

    public Venta(Date fchVen, Double monto, Usuario usuario, List<DetalleVenta> detalleVentaList) {
        this.fchVen = fchVen;
        this.monto = monto;
        this.usuario = usuario;
        this.detalleVentaList = detalleVentaList;
    }
}
