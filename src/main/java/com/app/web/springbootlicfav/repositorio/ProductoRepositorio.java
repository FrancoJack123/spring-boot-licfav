package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.estPro = true WHERE p.codPro = :productoId")
    void updateEstProToTrue(Long productoId);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.estPro = false WHERE p.codPro = :productoId")
    void updateEstProToFalse(Long productoId);
}
