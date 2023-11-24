package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long> {
    @Query("SELECT v FROM Venta v WHERE v.usuario.codUsua = :usuarioID")
    List<Venta> ListarVentasUsuario(@Param("usuarioID") Long usuarioID);
}
