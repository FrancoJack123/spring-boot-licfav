package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Rol;
import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.repositorio.RolRepositorio;
import com.app.web.springbootlicfav.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> ListarUsuario(){
        return usuarioRepositorio.findAll();
    }

    public Usuario BuscarUsuario(Long codigo){
        return usuarioRepositorio.findById(codigo).get();
    }

    public void GuardarUsuario(Usuario objeto){
        usuarioRepositorio.save(objeto);
    }

    public void EliminarUsuario(Long codigo){
        usuarioRepositorio.deleteById(codigo);
    }

    public Usuario Login(String user, String password){
        return usuarioRepositorio.Login(user, password);
    }
}
