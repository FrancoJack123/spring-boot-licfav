package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Long> {
}
