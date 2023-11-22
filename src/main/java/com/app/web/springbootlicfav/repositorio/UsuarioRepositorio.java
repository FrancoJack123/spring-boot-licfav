package com.app.web.springbootlicfav.repositorio;

import com.app.web.springbootlicfav.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.userUsua = :user AND u.claUsua = :password")
    Usuario Login(@Param("user") String user, @Param("password") String password);
}
