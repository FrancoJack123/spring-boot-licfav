package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {
}
