package com.app.web.springbootlicfav.servicio;

import com.app.web.springbootlicfav.entidad.DetalleVenta;
import com.app.web.springbootlicfav.entidad.Usuario;
import com.app.web.springbootlicfav.repositorio.DetalleVentaRepositorio;
import com.app.web.springbootlicfav.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServicio {
    @Autowired
    private DetalleVentaRepositorio detalleVentaRepositorio;

    public List<DetalleVenta> ListarDetalleVenta(){
        return detalleVentaRepositorio.findAll();
    }

    public DetalleVenta BuscarDetalleVenta(Long codigo){
        return detalleVentaRepositorio.findById(codigo).get();
    }

    public void GuardarDetalleVenta(DetalleVenta objeto){
        detalleVentaRepositorio.save(objeto);
    }

    public void EliminarDetalleVenta(Long codigo){
        detalleVentaRepositorio.deleteById(codigo);
    }
}
