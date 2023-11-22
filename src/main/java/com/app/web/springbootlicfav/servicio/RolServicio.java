package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Proveedor;
import com.app.web.springbootlicfav.entidad.Rol;
import com.app.web.springbootlicfav.repositorio.ProveedorRepositorio;
import com.app.web.springbootlicfav.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicio {
    @Autowired
    private RolRepositorio rolRepositorio;

    public List<Rol> ListarRol(){
        return rolRepositorio.findAll();
    }

    public Rol BuscarRol(Long codigo){
        return rolRepositorio.findById(codigo).get();
    }

    public void GuardarRol(Rol objeto){
        rolRepositorio.save(objeto);
    }

    public void EliminarRol(Long codigo){
        rolRepositorio.deleteById(codigo);
    }
}
