package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {
}
