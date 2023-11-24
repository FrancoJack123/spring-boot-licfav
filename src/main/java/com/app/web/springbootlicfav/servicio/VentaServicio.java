package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.entidad.Venta;
import com.app.web.springbootlicfav.repositorio.UsuarioRepositorio;
import com.app.web.springbootlicfav.repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServicio {
    @Autowired
    private VentaRepositorio ventaRepositorio;

    public List<Venta> ListarVenta(){
        return ventaRepositorio.findAll();
    }

    public List<Venta> ListarVentasUsuario(Long usuarioID){
        return ventaRepositorio.ListarVentasUsuario(usuarioID);
    }

    public Venta BuscarVenta(Long codigo){
        return ventaRepositorio.findById(codigo).get();
    }

    public void GuardarVenta(Venta objeto){
        ventaRepositorio.save(objeto);
    }

    public void EliminarVenta(Long codigo){
        ventaRepositorio.deleteById(codigo);
    }
}
