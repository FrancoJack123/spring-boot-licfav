package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
}
